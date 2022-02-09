<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::middleware('auth:api')->get('/user', function (Request $request) {
    return $request->user();
});
//

//DangNhap
Route::APIResource('DangNhap','API\DangNhapController');
//BanPhong
Route::APIResource('BanPhong','API\BanPhongController');
//Khu vuc
Route::APIResource('KhuVuc','API\KhuVucController');
//MonAn
Route::APIResource('MonAn','API\MonAnController');
//HoaDon
Route::APIResource('DonHang','API\DonHangController');