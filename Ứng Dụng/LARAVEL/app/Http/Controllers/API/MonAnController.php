<?php

namespace App\Http\Controllers\API;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
//
use Illuminate\Support\Facades\DB;
use Carbon\Carbon;

class MonAnController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()//lay ds món ân
    {
        
        $DSMonAn = DB::select('SELECT  SP.MaSP, SP.TenSP, SP.MaDVT, SP.SLDK, SP.GTDK, SP.MaNhom, NH.TenNhom
                                    FROM SanPham SP
                                        FULL JOIN NhomHang NH
                                            on SP.MaNhom = NH.MaNhom
                                WHERE SP.MaNhom NOT LIKE '."'MNNL'".
                                    'AND SP.MaNhom NOT LIKE'."'MNCB'".
                                    'AND SP.TrangThai = 1');
        return $DSMonAn;
        
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)//them sua sp vao hd theo hd
    {
        //
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)//hien mon an theo hoa don
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
    public function update(Request $request, $id)//thanh toan
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)//xoa hd
    {
        //
    }
}
