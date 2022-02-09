<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
//
use Illuminate\Support\Facades\DB;
use Carbon\Carbon;

class DonHangController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)// thanh toan
    {
        //gom maban, mact, cau lenh tao hay la thanh toan
        $MaCT = $this->KiemTraHD($request->SoBan);
        //cap nhat ban co thanh trong
        DB::table('BanPhong')
                ->where('SoBan', '=', $request->SoBan)
                ->update(['NoUse' => 0]);

        //cap nhât sl sp
        DB::table('ChungTu')
                ->where('SoCT', '=', $MaCT)
                ->update(
                    ['MaThuNgan' => $request->MaNV,
                    'SoTien' => $request->SoTien,
                    'TraTruoc' => 0,
                    'ConNo' => 0,
                    'NgayDat' => Carbon::now('Asia/Ho_Chi_Minh'),
                    'TrangThai' => 1]
                );
        return response()->json([
                'result' => 'success',
            ]);
    
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)//get lây ds sp trong hd thông qua ma ban và trang thai
    {
        //
        //lay ma ct
        $MaCT =  DB::select('SELECT TOP 1 SoCT        
                                FROM ChungTu                      
                                WHERE SoBan = '."'$id'".
                                        ' AND TrangThai = 0                     
                                ORDER BY SoCT DESC
                            ');
         
        foreach ($MaCT as $key)
        {
            $MaCT = $key->SoCT;
        }

        //lay ds mon an
        $DSMonAn =  DB::select('SELECT SP.MaSP, SP.TenSP ,CT.SoLuong ,CT.DonGia,SP.MaNhom
                                FROM DongCT CT 
                                    JOIN SanPham SP
                                        ON SP.MaSP = CT.MaSP
                                WHERE CT.SoCT = '."'$MaCT'"
                            );
        return $DSMonAn;

    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)//put them id ,them ,cap nhat sp 
    {
        //lay ma ct
        $MaCT = $this->KiemTraHD($id);
        
        
        if ( isset( $MaCT ) ) 
        {
            //echo Carbon::now('Asia/Ho_Chi_Minh');
            //echo $request->MaSP;
            //kiem tra sp ton tai chua
            $KiemTraSP = DB::table('DongCT')
                            ->where('SoCT', '=', $MaCT)
                            ->where('MaSP', '=', $request->MaSP)
                            ->first();
            if (is_null($KiemTraSP)) //kiem tra xem ton tai hay chua
            {
                //SP chua ton tai
                //them sp vao ct
                DB::table('DongCT')->insert([
                            'SoCT' => $MaCT,
                            'MaSP' => $request->MaSP,
                            'MaDVT' => $request->MaDVT,
                            'SoLuong' => $request->SoLuong,
                            'DonGia' =>$request->DonGia,
                            'GioVao' => Carbon::now('Asia/Ho_Chi_Minh'),
                            'TraLai' => 0,
                            'Giam' => 0
                        ]);
                return response()->json([
                    'result' => 'success',
                ]);
            } 
            else 
            {
             //SP da ton tai 
                //cap nhât sl sp
                DB::table('DongCT')
                    ->where('SoCT', '=', $MaCT)
                    ->where('MaSP', '=', $request->MaSP)
                    ->update([
                           'SoLuong' => DB::raw('SoLuong + '.$request->SoLuong)
                            ]);
                return response()->json([
                    'result' => 'success',
                ]);
            }

        }
        else 
        {
            //cap nhat ban co ng su dung
            DB::table('BanPhong')
                    ->where('SoBan', '=', $id)
                    ->update(['NoUse' => 1]);
            //tao hd t
            $Time = "CT".Carbon::now('Asia/Ho_Chi_Minh')->format('dmYHis');
            //tao hd
            DB::table('ChungTu')->insert([
                            'SoCT' => $Time,
                            'NgayCT' => Carbon::now('Asia/Ho_Chi_Minh'),
                            'Loai' => 0,
                            'SoBan' => $id,
                            'MaKH' =>"KH01",
                            'SoKhach' => 1,
                            'NoiDung' => "Bán Lẻ",
                            'MaNhanVien' => $request->MaNV,
                            'Giam' => 0,
                            'ThueVAT' => 0,
                            'PhiDV' => 0,
                            'TrangThai' => 0,
                        ]);
            //them sp vao dongct
            //them sp vao ct
                DB::table('DongCT')->insert([
                            'SoCT' => $Time,
                            'MaSP' => $request->MaSP,
                            'MaDVT' => $request->MaDVT,
                            'SoLuong' => $request->SoLuong,
                            'DonGia' =>$request->DonGia,
                            'GioVao' => Carbon::now('Asia/Ho_Chi_Minh'),
                            'TraLai' => 0,
                            'Giam' => 0
                        ]);
                return response()->json([
                    'result' => 'success',
                ]);

        }
        //id la ma ban
        //requset gom ma ban, masp, sl,gia
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        //
        $pieces = explode("-", $id);
        $pieces[0]; // ma ban
        $pieces[1]; // masp
        $MaCT = $this->KiemTraHD($pieces[0]);
        DB::table('DongCT')
        ->where('MaSP', '=', $pieces[1])
        ->where('SoCT', '=', $MaCT)
        ->delete();
        return response()
            ->json([
                'result' => 'success',
                ]);

    }   

    //hàm kiem tra ma hd
    public function KiemTraHD( $SoBan )
    {
        $MaCT = null;
        $KiemTra =  DB::select('SELECT TOP 1 SoCT        
                                FROM ChungTu                      
                                WHERE SoBan = '."'$SoBan'".
                                        ' AND TrangThai = 0                     
                                ORDER BY SoCT DESC
                            ');
         
        foreach ($KiemTra as $key)
        {
            $MaCT = $key->SoCT;
        }
        return $MaCT;
    }
   
}
