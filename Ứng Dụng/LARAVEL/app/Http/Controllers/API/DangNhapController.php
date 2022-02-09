<?php

namespace App\Http\Controllers\API;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
//
use Illuminate\Support\Facades\DB;

class DangNhapController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        //
        echo "DangNhapController";
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        //
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        //
        $KiemTraTK = DB::table('TaiKhoan')
                            ->where('TaiKhoan', '=', $request->TaiKhoan)
                            ->where('MatKhau', '=', $request->MatKhau)
                            ->first();

        if (is_null($KiemTraTK)) //kiem tra xem ton tai hay chua
            {
              return response()->json([
                        'result' => 'fail',
                        ]);
            } 
            else 
            {//lay thong tin tai khoan
                $MaNV = "";
                $ThongTin = DB::select('SELECT TK.MaNV, NV.HoTen, NV.DienThoai
                                            FROM TaiKhoan TK
                                                FULL JOIN NhanVien NV
                                                    on TK.MaNV = NV.MaNV
                                        WHERE   TK.TaiKhoan ='."'$request->TaiKhoan'".
                                                'AND TK.MatKhau ='."'$request->MatKhau'".
                                                'AND NV.MaBP NOT LIKE'."'BPOT'");
                foreach ($ThongTin as $key)
                {
                    $MaNV = $key->MaNV;
                    $HoTen = $key->HoTen;
                    $DienThoai = $key->DienThoai;
                }
                
                if( isset($MaNV) and isset($HoTen))
                {
                    return response()->json([
                        'result' => 'success',
                        'MaNV' => $MaNV,
                        'HoTen' => $HoTen,
                        'DienThoai' => $DienThoai
                        ]);
                }
                else
                {
                    return response()->json([
                        'result' => 'fail',
                        ]);
                }
            }

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
    }
}
