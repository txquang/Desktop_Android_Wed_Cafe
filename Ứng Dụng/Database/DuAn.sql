USE [DuAn]
GO
/****** Object:  Table [dbo].[BangGia]    Script Date: T2 11 01 2021 08:42:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BangGia](
	[ID] [int] NOT NULL,
	[MaSP] [nvarchar](16) NULL,
	[MaBG] [nvarchar](16) NULL,
	[DonGia] [float] NULL,
	[Giam] [float] NULL,
 CONSTRAINT [PK_BangGia] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[BanPhong]    Script Date: T2 11 01 2021 08:42:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BanPhong](
	[SoBan] [nvarchar](16) NOT NULL,
	[MaKV] [nvarchar](16) NULL,
	[MaBG] [nvarchar](5) NULL,
	[NoUse] [tinyint] NULL,
	[TenBan] [nvarchar](100) NULL,
 CONSTRAINT [PK_BanPhong] PRIMARY KEY CLUSTERED 
(
	[SoBan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[BoPhan]    Script Date: T2 11 01 2021 08:42:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BoPhan](
	[MaBP] [nvarchar](16) NOT NULL,
	[TenBP] [nvarchar](50) NULL,
 CONSTRAINT [PK_BoPhan] PRIMARY KEY CLUSTERED 
(
	[MaBP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ChungTu]    Script Date: T2 11 01 2021 08:42:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChungTu](
	[SoCT] [nvarchar](16) NOT NULL,
	[NgayCT] [datetime] NULL,
	[Loai] [tinyint] NULL,
	[SoBan] [nvarchar](16) NULL,
	[MaKH] [nvarchar](16) NULL,
	[SoKhach] [int] NULL,
	[NoiDung] [nvarchar](250) NULL,
	[MaThuNgan] [nvarchar](16) NULL,
	[MaNhanVien] [nvarchar](16) NULL,
	[Giam] [float] NULL,
	[ThueVAT] [float] NULL,
	[PhiDV] [float] NULL,
	[SoTien] [float] NULL,
	[TraTruoc] [float] NULL,
	[ConNo] [float] NULL,
	[NgayDat] [datetime] NULL,
	[TrangThai] [tinyint] NULL,
 CONSTRAINT [PK_ChungTu] PRIMARY KEY CLUSTERED 
(
	[SoCT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DongCT]    Script Date: T2 11 01 2021 08:42:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DongCT](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[SoCT] [nvarchar](16) NULL,
	[MaSP] [nvarchar](16) NULL,
	[MaDVT] [nvarchar](7) NULL,
	[SoLuong] [int] NULL,
	[DonGia] [float] NULL,
	[GioVao] [datetime] NULL,
	[GioRa] [datetime] NULL,
	[TraLai] [int] NULL,
	[Giam] [float] NULL,
	[GhiChu] [nvarchar](250) NULL,
 CONSTRAINT [PK_DongCT] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DonViTinh]    Script Date: T2 11 01 2021 08:42:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DonViTinh](
	[MaDVT] [nvarchar](16) NOT NULL,
	[MaDinh] [tinyint] NULL,
 CONSTRAINT [PK_DonViTinh] PRIMARY KEY CLUSTERED 
(
	[MaDVT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DVTKhac]    Script Date: T2 11 01 2021 08:42:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DVTKhac](
	[ID] [int] NOT NULL,
	[MaSP] [nvarchar](16) NULL,
	[MaDVT] [nvarchar](7) NULL,
	[QuyDoi] [float] NULL,
	[IsMenu] [tinyint] NULL,
 CONSTRAINT [PK_DVTKhac] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: T2 11 01 2021 08:42:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKH] [nvarchar](16) NOT NULL,
	[MaNhom] [nvarchar](16) NULL,
	[TenKH] [nvarchar](50) NULL,
	[DiaChi] [nvarchar](250) NULL,
	[DienThoai] [nvarchar](10) NULL,
	[MaSoThue] [nvarchar](12) NULL,
	[ThuDK] [float] NULL,
	[TraDK] [float] NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[KhuVuc]    Script Date: T2 11 01 2021 08:42:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhuVuc](
	[MaKV] [nvarchar](16) NOT NULL,
	[TenKV] [nvarchar](50) NULL,
 CONSTRAINT [PK_KhuVuc] PRIMARY KEY CLUSTERED 
(
	[MaKV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[LoaiBangGia]    Script Date: T2 11 01 2021 08:42:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiBangGia](
	[MaBG] [nvarchar](16) NOT NULL,
	[TenBG] [nvarchar](50) NULL,
	[MatDinh] [tinyint] NULL,
 CONSTRAINT [PK_LoaiBangGia] PRIMARY KEY CLUSTERED 
(
	[MaBG] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: T2 11 01 2021 08:42:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNV] [nvarchar](16) NOT NULL,
	[MaBP] [nvarchar](16) NULL,
	[HoTen] [nvarchar](50) NULL,
	[DiaChi] [nvarchar](250) NULL,
	[DienThoai] [nvarchar](10) NULL,
	[MaSoThue] [nvarchar](21) NULL,
	[IsKeToan] [tinyint] NULL,
	[IsThuNgan] [tinyint] NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[NhomHang]    Script Date: T2 11 01 2021 08:42:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhomHang](
	[MaNhom] [nvarchar](16) NOT NULL,
	[MaCha] [nvarchar](5) NULL,
	[TenNhom] [nvarchar](50) NULL,
	[LoaiNhom] [tinyint] NULL,
 CONSTRAINT [PK_NhomHang] PRIMARY KEY CLUSTERED 
(
	[MaNhom] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[NhomKhach]    Script Date: T2 11 01 2021 08:42:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhomKhach](
	[MaNhom] [nvarchar](16) NOT NULL,
	[MaCha] [nvarchar](5) NULL,
	[TenNhom] [nvarchar](50) NULL,
	[LoaiNhom] [tinyint] NULL,
 CONSTRAINT [PK_NhomKhach] PRIMARY KEY CLUSTERED 
(
	[MaNhom] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[SanPham]    Script Date: T2 11 01 2021 08:42:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[MaSP] [nvarchar](16) NOT NULL,
	[MaNhom] [nvarchar](16) NULL,
	[TenSP] [nvarchar](50) NULL,
	[MaDVT] [nvarchar](16) NULL,
	[SLDK] [int] NULL,
	[GTDK] [float] NULL,
	[TrangThai] [int] NULL,
 CONSTRAINT [PK_SanPham] PRIMARY KEY CLUSTERED 
(
	[MaSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: T2 11 01 2021 08:42:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[MaNV] [nvarchar](16) NOT NULL,
	[TaiKhoan] [char](10) NULL,
	[MatKhau] [char](10) NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ThanhPhan]    Script Date: T2 11 01 2021 08:42:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThanhPhan](
	[ID] [int] NOT NULL,
	[MaSP] [nvarchar](16) NULL,
	[MaDVT] [nvarchar](7) NULL,
	[MaTP] [nvarchar](20) NULL,
	[MaDVTTP] [nvarchar](7) NULL,
	[SoLuong] [float] NULL,
 CONSTRAINT [PK_ThanhPhan] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[BangGia] ([ID], [MaSP], [MaBG], [DonGia], [Giam]) VALUES (1, N'SP01', N'BGBS', 3000, NULL)
INSERT [dbo].[BangGia] ([ID], [MaSP], [MaBG], [DonGia], [Giam]) VALUES (2, N'SP02', N'BGBL', 10000, NULL)
INSERT [dbo].[BangGia] ([ID], [MaSP], [MaBG], [DonGia], [Giam]) VALUES (3, N'SP03', N'BGBL', 6000, NULL)
INSERT [dbo].[BangGia] ([ID], [MaSP], [MaBG], [DonGia], [Giam]) VALUES (4, N'SP01', N'BGBS', 4000, NULL)
INSERT [dbo].[BangGia] ([ID], [MaSP], [MaBG], [DonGia], [Giam]) VALUES (5, N'SP02', N'BGBL', 11000, NULL)
INSERT [dbo].[BangGia] ([ID], [MaSP], [MaBG], [DonGia], [Giam]) VALUES (6, N'SP03', N'BGBS', 7000, NULL)
INSERT [dbo].[BanPhong] ([SoBan], [MaKV], [MaBG], [NoUse], [TenBan]) VALUES (N'SB01', N'KVTP', N'BGBL', 1, N'Bàn Số 01')
INSERT [dbo].[BanPhong] ([SoBan], [MaKV], [MaBG], [NoUse], [TenBan]) VALUES (N'SB02', N'KVTP', N'BGBL', 1, N'Bàn Số 02')
INSERT [dbo].[BanPhong] ([SoBan], [MaKV], [MaBG], [NoUse], [TenBan]) VALUES (N'SB03', N'KVTP', N'BGBL', 0, N'Bàn Số 03')
INSERT [dbo].[BanPhong] ([SoBan], [MaKV], [MaBG], [NoUse], [TenBan]) VALUES (N'SB04', N'KVTP', N'BGBL', 0, N'Bàn Số 04')
INSERT [dbo].[BanPhong] ([SoBan], [MaKV], [MaBG], [NoUse], [TenBan]) VALUES (N'SB05', N'KVTP', N'BGNT', 4, N'Bàn Số 05')
INSERT [dbo].[BanPhong] ([SoBan], [MaKV], [MaBG], [NoUse], [TenBan]) VALUES (N'SB06', N'KVNT', N'BGNT', 0, N'Bàn Số 06')
INSERT [dbo].[BanPhong] ([SoBan], [MaKV], [MaBG], [NoUse], [TenBan]) VALUES (N'SB07', N'KVNT', N'BGTP', 2, N'Bàn Số 07')
INSERT [dbo].[BanPhong] ([SoBan], [MaKV], [MaBG], [NoUse], [TenBan]) VALUES (N'SB08', N'KVNT', N'BGTP', 0, N'Bàn Số 08')
INSERT [dbo].[BanPhong] ([SoBan], [MaKV], [MaBG], [NoUse], [TenBan]) VALUES (N'SB09', N'KVNT', N'BGTP', 0, N'Bàn Số 09')
INSERT [dbo].[BanPhong] ([SoBan], [MaKV], [MaBG], [NoUse], [TenBan]) VALUES (N'SB10', N'KVNT', N'BGBL', 0, N'Bàn Số 10')
INSERT [dbo].[BanPhong] ([SoBan], [MaKV], [MaBG], [NoUse], [TenBan]) VALUES (N'SB20210103094912', N'KVTP', N'BGNT', 0, N'gfgg121')
INSERT [dbo].[BoPhan] ([MaBP], [TenBP]) VALUES (N'BPKT', N'Kế Toán')
INSERT [dbo].[BoPhan] ([MaBP], [TenBP]) VALUES (N'BPOT', N'Nghĩ Làm')
INSERT [dbo].[BoPhan] ([MaBP], [TenBP]) VALUES (N'BPQL', N'Quản lý')
INSERT [dbo].[BoPhan] ([MaBP], [TenBP]) VALUES (N'BPTN', N'Thu ngân')
INSERT [dbo].[ChungTu] ([SoCT], [NgayCT], [Loai], [SoBan], [MaKH], [SoKhach], [NoiDung], [MaThuNgan], [MaNhanVien], [Giam], [ThueVAT], [PhiDV], [SoTien], [TraTruoc], [ConNo], [NgayDat], [TrangThai]) VALUES (N'CT01', CAST(N'2019-09-17 16:04:25.000' AS DateTime), 0, N'SB01', N'KH06', 1, N'Nhập Kho', N'NV07', N'NV07', 0, 0, 0, 21000, 100000, 79000, CAST(N'2019-09-16 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[ChungTu] ([SoCT], [NgayCT], [Loai], [SoBan], [MaKH], [SoKhach], [NoiDung], [MaThuNgan], [MaNhanVien], [Giam], [ThueVAT], [PhiDV], [SoTien], [TraTruoc], [ConNo], [NgayDat], [TrangThai]) VALUES (N'CT02', CAST(N'2019-09-18 16:04:25.000' AS DateTime), 2, N'SB02', N'KH01', 5, N'Bán Lẻ', N'NV03', N'NV03', 0, 0, 0, 13000, 10000, -3000, CAST(N'2019-09-17 17:04:25.000' AS DateTime), 1)
INSERT [dbo].[ChungTu] ([SoCT], [NgayCT], [Loai], [SoBan], [MaKH], [SoKhach], [NoiDung], [MaThuNgan], [MaNhanVien], [Giam], [ThueVAT], [PhiDV], [SoTien], [TraTruoc], [ConNo], [NgayDat], [TrangThai]) VALUES (N'CT04', CAST(N'2019-11-30 09:32:12.000' AS DateTime), NULL, N'SB01', NULL, 1, NULL, N'NV01', N'NV01', 0, 0, 0, 21000, 150000, 129000, CAST(N'2020-12-23 09:04:48.000' AS DateTime), 1)
INSERT [dbo].[ChungTu] ([SoCT], [NgayCT], [Loai], [SoBan], [MaKH], [SoKhach], [NoiDung], [MaThuNgan], [MaNhanVien], [Giam], [ThueVAT], [PhiDV], [SoTien], [TraTruoc], [ConNo], [NgayDat], [TrangThai]) VALUES (N'CT09012021131859', CAST(N'2021-01-09 13:18:59.320' AS DateTime), 0, N'SB10', N'KH01', 1, N'Bán Lẻ', N'NV01', N'NV01', 0, 0, 0, 15000, 0, 0, CAST(N'2021-01-09 13:19:08.467' AS DateTime), 1)
INSERT [dbo].[ChungTu] ([SoCT], [NgayCT], [Loai], [SoBan], [MaKH], [SoKhach], [NoiDung], [MaThuNgan], [MaNhanVien], [Giam], [ThueVAT], [PhiDV], [SoTien], [TraTruoc], [ConNo], [NgayDat], [TrangThai]) VALUES (N'CT09012021132113', CAST(N'2021-01-09 13:21:13.570' AS DateTime), 0, N'SB03', N'KH01', 1, N'Bán Lẻ', N'NV01', N'NV01', 0, 0, 0, 15000, 0, 0, CAST(N'2021-01-09 13:21:25.857' AS DateTime), 1)
INSERT [dbo].[ChungTu] ([SoCT], [NgayCT], [Loai], [SoBan], [MaKH], [SoKhach], [NoiDung], [MaThuNgan], [MaNhanVien], [Giam], [ThueVAT], [PhiDV], [SoTien], [TraTruoc], [ConNo], [NgayDat], [TrangThai]) VALUES (N'CT09012021132248', CAST(N'2021-01-09 13:22:48.397' AS DateTime), 0, N'SB08', N'KH01', 1, N'Bán Lẻ', N'NV01', N'NV01', 0, 0, 0, 15000, 0, 0, CAST(N'2021-01-09 13:23:06.117' AS DateTime), 1)
INSERT [dbo].[ChungTu] ([SoCT], [NgayCT], [Loai], [SoBan], [MaKH], [SoKhach], [NoiDung], [MaThuNgan], [MaNhanVien], [Giam], [ThueVAT], [PhiDV], [SoTien], [TraTruoc], [ConNo], [NgayDat], [TrangThai]) VALUES (N'CT20201222190757', CAST(N'2020-12-22 19:07:57.000' AS DateTime), NULL, N'SB02', NULL, 1, N'Bán Lẻ', NULL, N'NV01', 0, 0, 0, 119000, NULL, NULL, NULL, 0)
INSERT [dbo].[ChungTu] ([SoCT], [NgayCT], [Loai], [SoBan], [MaKH], [SoKhach], [NoiDung], [MaThuNgan], [MaNhanVien], [Giam], [ThueVAT], [PhiDV], [SoTien], [TraTruoc], [ConNo], [NgayDat], [TrangThai]) VALUES (N'CT20201223090502', CAST(N'2020-12-23 09:05:02.000' AS DateTime), NULL, N'SB01', NULL, 1, N'Bán Lẻ', NULL, N'NV01', 0, 0, 0, 46000, NULL, NULL, NULL, 0)
INSERT [dbo].[ChungTu] ([SoCT], [NgayCT], [Loai], [SoBan], [MaKH], [SoKhach], [NoiDung], [MaThuNgan], [MaNhanVien], [Giam], [ThueVAT], [PhiDV], [SoTien], [TraTruoc], [ConNo], [NgayDat], [TrangThai]) VALUES (N'CT20210107204627', CAST(N'2021-01-07 20:46:27.000' AS DateTime), NULL, N'SB10', NULL, 1, N'Bán Lẻ', N'NV01', N'NV01', 0, 0, 0, 450000, 0, 0, CAST(N'2021-01-09 10:15:05.633' AS DateTime), 1)
SET IDENTITY_INSERT [dbo].[DongCT] ON 

INSERT [dbo].[DongCT] ([ID], [SoCT], [MaSP], [MaDVT], [SoLuong], [DonGia], [GioVao], [GioRa], [TraLai], [Giam], [GhiChu]) VALUES (1, N'CT01', N'SP08', N'Lon', 1, 15000, CAST(N'2019-09-17 05:00:00.000' AS DateTime), CAST(N'2019-09-17 05:01:00.000' AS DateTime), 0, 0, N'')
INSERT [dbo].[DongCT] ([ID], [SoCT], [MaSP], [MaDVT], [SoLuong], [DonGia], [GioVao], [GioRa], [TraLai], [Giam], [GhiChu]) VALUES (2, N'CT01', N'SP03', N'Lon', 2, 6000, NULL, NULL, 1, NULL, NULL)
INSERT [dbo].[DongCT] ([ID], [SoCT], [MaSP], [MaDVT], [SoLuong], [DonGia], [GioVao], [GioRa], [TraLai], [Giam], [GhiChu]) VALUES (3, N'CT02', N'SP09', N'Lon', 1, 13000, CAST(N'2019-09-17 08:00:00.000' AS DateTime), CAST(N'2019-09-17 08:00:00.000' AS DateTime), 0, 0, NULL)
INSERT [dbo].[DongCT] ([ID], [SoCT], [MaSP], [MaDVT], [SoLuong], [DonGia], [GioVao], [GioRa], [TraLai], [Giam], [GhiChu]) VALUES (6, N'CT04', N'SP01', N'Chai', 1, 3000, CAST(N'2019-11-30 09:32:12.000' AS DateTime), NULL, NULL, NULL, NULL)
INSERT [dbo].[DongCT] ([ID], [SoCT], [MaSP], [MaDVT], [SoLuong], [DonGia], [GioVao], [GioRa], [TraLai], [Giam], [GhiChu]) VALUES (7, N'CT04', N'SP05', N'Kg', 6, 12000, CAST(N'2019-11-30 09:32:12.000' AS DateTime), NULL, NULL, NULL, NULL)
INSERT [dbo].[DongCT] ([ID], [SoCT], [MaSP], [MaDVT], [SoLuong], [DonGia], [GioVao], [GioRa], [TraLai], [Giam], [GhiChu]) VALUES (9, N'CT04', N'SP09', N'Chai', 2, 3000, CAST(N'2019-11-30 09:32:12.000' AS DateTime), NULL, NULL, 0, NULL)
INSERT [dbo].[DongCT] ([ID], [SoCT], [MaSP], [MaDVT], [SoLuong], [DonGia], [GioVao], [GioRa], [TraLai], [Giam], [GhiChu]) VALUES (12, N'CT04', N'SP02', N'Lon', 1, 10000, CAST(N'2019-11-30 09:32:12.000' AS DateTime), NULL, 0, 0, NULL)
INSERT [dbo].[DongCT] ([ID], [SoCT], [MaSP], [MaDVT], [SoLuong], [DonGia], [GioVao], [GioRa], [TraLai], [Giam], [GhiChu]) VALUES (13, N'CT04', N'SP12', N'Ly', 1, 11000, CAST(N'2019-11-30 09:32:12.000' AS DateTime), NULL, 0, 0, NULL)
INSERT [dbo].[DongCT] ([ID], [SoCT], [MaSP], [MaDVT], [SoLuong], [DonGia], [GioVao], [GioRa], [TraLai], [Giam], [GhiChu]) VALUES (15, N'CT20201222190757', N'SP07', N'Kg', 1, 35000, NULL, NULL, 0, 0, NULL)
INSERT [dbo].[DongCT] ([ID], [SoCT], [MaSP], [MaDVT], [SoLuong], [DonGia], [GioVao], [GioRa], [TraLai], [Giam], [GhiChu]) VALUES (17, N'CT20201222190757', N'SP13', N'Ly', 2, 15000, NULL, NULL, 0, 0, NULL)
INSERT [dbo].[DongCT] ([ID], [SoCT], [MaSP], [MaDVT], [SoLuong], [DonGia], [GioVao], [GioRa], [TraLai], [Giam], [GhiChu]) VALUES (19, N'CT20201222190757', N'SP03', N'Lon', 1, 6000, NULL, NULL, 0, 0, NULL)
INSERT [dbo].[DongCT] ([ID], [SoCT], [MaSP], [MaDVT], [SoLuong], [DonGia], [GioVao], [GioRa], [TraLai], [Giam], [GhiChu]) VALUES (20, N'CT20201223090502', N'SP07', N'Kg', 1, 35000, NULL, NULL, 0, 0, NULL)
INSERT [dbo].[DongCT] ([ID], [SoCT], [MaSP], [MaDVT], [SoLuong], [DonGia], [GioVao], [GioRa], [TraLai], [Giam], [GhiChu]) VALUES (1018, N'CT20210107204627', N'SP10', N'Bao', 3, 150000, CAST(N'2021-01-09 08:46:06.960' AS DateTime), NULL, 0, 0, NULL)
INSERT [dbo].[DongCT] ([ID], [SoCT], [MaSP], [MaDVT], [SoLuong], [DonGia], [GioVao], [GioRa], [TraLai], [Giam], [GhiChu]) VALUES (1020, N'CT09012021131859', N'SP13', N'Ly', 1, 15000, CAST(N'2021-01-09 13:18:59.397' AS DateTime), NULL, 0, 0, NULL)
INSERT [dbo].[DongCT] ([ID], [SoCT], [MaSP], [MaDVT], [SoLuong], [DonGia], [GioVao], [GioRa], [TraLai], [Giam], [GhiChu]) VALUES (1021, N'CT09012021132113', N'SP13', N'Ly', 1, 15000, CAST(N'2021-01-09 13:21:13.573' AS DateTime), NULL, 0, 0, NULL)
INSERT [dbo].[DongCT] ([ID], [SoCT], [MaSP], [MaDVT], [SoLuong], [DonGia], [GioVao], [GioRa], [TraLai], [Giam], [GhiChu]) VALUES (1022, N'CT09012021132248', N'SP13', N'Ly', 1, 15000, CAST(N'2021-01-09 13:22:48.400' AS DateTime), NULL, 0, 0, NULL)
SET IDENTITY_INSERT [dbo].[DongCT] OFF
INSERT [dbo].[DonViTinh] ([MaDVT], [MaDinh]) VALUES (N'Bao', NULL)
INSERT [dbo].[DonViTinh] ([MaDVT], [MaDinh]) VALUES (N'Chai', NULL)
INSERT [dbo].[DonViTinh] ([MaDVT], [MaDinh]) VALUES (N'Hộp', NULL)
INSERT [dbo].[DonViTinh] ([MaDVT], [MaDinh]) VALUES (N'Kg', NULL)
INSERT [dbo].[DonViTinh] ([MaDVT], [MaDinh]) VALUES (N'Lan', NULL)
INSERT [dbo].[DonViTinh] ([MaDVT], [MaDinh]) VALUES (N'Lon', NULL)
INSERT [dbo].[DonViTinh] ([MaDVT], [MaDinh]) VALUES (N'Ly', NULL)
INSERT [dbo].[DVTKhac] ([ID], [MaSP], [MaDVT], [QuyDoi], [IsMenu]) VALUES (1, N'SP04', N'Kg', 1000, NULL)
INSERT [dbo].[DVTKhac] ([ID], [MaSP], [MaDVT], [QuyDoi], [IsMenu]) VALUES (2, N'SP02', N'Thung', 24, NULL)
INSERT [dbo].[DVTKhac] ([ID], [MaSP], [MaDVT], [QuyDoi], [IsMenu]) VALUES (3, N'SP10', N'Bao', 10, NULL)
INSERT [dbo].[KhachHang] ([MaKH], [MaNhom], [TenKH], [DiaChi], [DienThoai], [MaSoThue], [ThuDK], [TraDK]) VALUES (N'KH01', N'MNKH', N'Khoa', N'Huế', N'0123456798', N'MT01', 0, 0)
INSERT [dbo].[KhachHang] ([MaKH], [MaNhom], [TenKH], [DiaChi], [DienThoai], [MaSoThue], [ThuDK], [TraDK]) VALUES (N'KH02', N'MNKH', N'Nghĩa', N'Huế', N'0123456798', N'MT02', 0, 0)
INSERT [dbo].[KhachHang] ([MaKH], [MaNhom], [TenKH], [DiaChi], [DienThoai], [MaSoThue], [ThuDK], [TraDK]) VALUES (N'KH03', N'MNKH', N'Bạch', N'Huế', N'0123465789', N'MT03', 0, 0)
INSERT [dbo].[KhachHang] ([MaKH], [MaNhom], [TenKH], [DiaChi], [DienThoai], [MaSoThue], [ThuDK], [TraDK]) VALUES (N'KH04', N'MNKH', N'Bé', N'Huế', N'0123456987', N'MT04', 0, 0)
INSERT [dbo].[KhachHang] ([MaKH], [MaNhom], [TenKH], [DiaChi], [DienThoai], [MaSoThue], [ThuDK], [TraDK]) VALUES (N'KH05', N'MNKH', N'Trang', N'Huế', N'0123654789', N'MT05', 0, 0)
INSERT [dbo].[KhachHang] ([MaKH], [MaNhom], [TenKH], [DiaChi], [DienThoai], [MaSoThue], [ThuDK], [TraDK]) VALUES (N'KH06', N'MNNC', N'Công ty A', N'Đà Nẵng', N'0123454668', N'MT06', 8000000, 4000000)
INSERT [dbo].[KhachHang] ([MaKH], [MaNhom], [TenKH], [DiaChi], [DienThoai], [MaSoThue], [ThuDK], [TraDK]) VALUES (N'KH07', N'MNNC', N'Cơ sở Xay sát', N'Huế', N'0123478594', N'MT07', 100000, 100000)
INSERT [dbo].[KhachHang] ([MaKH], [MaNhom], [TenKH], [DiaChi], [DienThoai], [MaSoThue], [ThuDK], [TraDK]) VALUES (N'KH08', N'MNKH', N'Khách Lẻ', N'XXX', N'XXX', N'XXX', 0, 0)
INSERT [dbo].[KhuVuc] ([MaKV], [TenKV]) VALUES (N'KVNT', N'Ngoài Trời')
INSERT [dbo].[KhuVuc] ([MaKV], [TenKV]) VALUES (N'KVPL', N'May Lạnh')
INSERT [dbo].[KhuVuc] ([MaKV], [TenKV]) VALUES (N'KVTP', N'Trong Phòng')
INSERT [dbo].[LoaiBangGia] ([MaBG], [TenBG], [MatDinh]) VALUES (N'BGBL', N'Bán Lẻ', NULL)
INSERT [dbo].[LoaiBangGia] ([MaBG], [TenBG], [MatDinh]) VALUES (N'BGBS', N'Bán Sỉ', NULL)
INSERT [dbo].[NhanVien] ([MaNV], [MaBP], [HoTen], [DiaChi], [DienThoai], [MaSoThue], [IsKeToan], [IsThuNgan]) VALUES (N'NV01', N'BPKT', N'Trần Văn Cường', N'Đà Nẵng', N'0123456789', N'MT11', NULL, NULL)
INSERT [dbo].[NhanVien] ([MaNV], [MaBP], [HoTen], [DiaChi], [DienThoai], [MaSoThue], [IsKeToan], [IsThuNgan]) VALUES (N'NV02', N'BPOT', N'Bùi Xuân Lộc', N'Huế', N'0123456789', N'MT12', NULL, NULL)
INSERT [dbo].[NhanVien] ([MaNV], [MaBP], [HoTen], [DiaChi], [DienThoai], [MaSoThue], [IsKeToan], [IsThuNgan]) VALUES (N'NV03', N'BPKT', N'Nguyễn Tiến Đạt', N'Huế', N'0123456789', N'MT13', 1, 1)
INSERT [dbo].[NhanVien] ([MaNV], [MaBP], [HoTen], [DiaChi], [DienThoai], [MaSoThue], [IsKeToan], [IsThuNgan]) VALUES (N'NV04', N'BPKT', N'Trần  Văn Thắng', N'Huế', N'0123456789', N'MT14', 1, 1)
INSERT [dbo].[NhanVien] ([MaNV], [MaBP], [HoTen], [DiaChi], [DienThoai], [MaSoThue], [IsKeToan], [IsThuNgan]) VALUES (N'NV05', N'BPKT', N'Trần Văn Phông', N'Huế', N'0123456789', N'MT15', 1, NULL)
INSERT [dbo].[NhanVien] ([MaNV], [MaBP], [HoTen], [DiaChi], [DienThoai], [MaSoThue], [IsKeToan], [IsThuNgan]) VALUES (N'NV06', N'BPTN', N'Bùi Văn Tư', N'Vinh', N'0123456789', N'MT16', 1, NULL)
INSERT [dbo].[NhanVien] ([MaNV], [MaBP], [HoTen], [DiaChi], [DienThoai], [MaSoThue], [IsKeToan], [IsThuNgan]) VALUES (N'NV07', N'BPTN', N'Trương trung Hiếu', N'Huế', N'0123456789', N'MT17', NULL, 1)
INSERT [dbo].[NhanVien] ([MaNV], [MaBP], [HoTen], [DiaChi], [DienThoai], [MaSoThue], [IsKeToan], [IsThuNgan]) VALUES (N'NV08', N'BPTN', N'Lê Văn Thiện', N'Huế', N'0123469787', N'MT18', NULL, 1)
INSERT [dbo].[NhanVien] ([MaNV], [MaBP], [HoTen], [DiaChi], [DienThoai], [MaSoThue], [IsKeToan], [IsThuNgan]) VALUES (N'NV09', N'BPTN', N'Kha Ban', N'Vinh', N'0123469787', N'MT19', NULL, 1)
INSERT [dbo].[NhanVien] ([MaNV], [MaBP], [HoTen], [DiaChi], [DienThoai], [MaSoThue], [IsKeToan], [IsThuNgan]) VALUES (N'NV10', N'BPTN', N'Khoa', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[NhanVien] ([MaNV], [MaBP], [HoTen], [DiaChi], [DienThoai], [MaSoThue], [IsKeToan], [IsThuNgan]) VALUES (N'NV99', N'BPQL', N'Admin', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[NhomHang] ([MaNhom], [MaCha], [TenNhom], [LoaiNhom]) VALUES (N'MNAU', NULL, N'Thức ăn', 0)
INSERT [dbo].[NhomHang] ([MaNhom], [MaCha], [TenNhom], [LoaiNhom]) VALUES (N'MNCB', NULL, N'Chế Biến', 2)
INSERT [dbo].[NhomHang] ([MaNhom], [MaCha], [TenNhom], [LoaiNhom]) VALUES (N'MNCF', NULL, N'CaFe', NULL)
INSERT [dbo].[NhomHang] ([MaNhom], [MaCha], [TenNhom], [LoaiNhom]) VALUES (N'MNDV', NULL, N'Dịch vụ', 3)
INSERT [dbo].[NhomHang] ([MaNhom], [MaCha], [TenNhom], [LoaiNhom]) VALUES (N'MNNL', NULL, N'Nguyên liệu', 1)
INSERT [dbo].[NhomHang] ([MaNhom], [MaCha], [TenNhom], [LoaiNhom]) VALUES (N'MNNU', NULL, N'Nước uống', 0)
INSERT [dbo].[NhomKhach] ([MaNhom], [MaCha], [TenNhom], [LoaiNhom]) VALUES (N'MNKH', NULL, N'Nhóm khách hàng', 0)
INSERT [dbo].[NhomKhach] ([MaNhom], [MaCha], [TenNhom], [LoaiNhom]) VALUES (N'MNNC', NULL, N'Nhà cung cấp', 1)
INSERT [dbo].[NhomKhach] ([MaNhom], [MaCha], [TenNhom], [LoaiNhom]) VALUES (N'MNTX', NULL, N'Khách hàng thường xuyên', 0)
INSERT [dbo].[SanPham] ([MaSP], [MaNhom], [TenSP], [MaDVT], [SLDK], [GTDK], [TrangThai]) VALUES (N'SP01', N'MNNU', N'Nước lọc', N'Chai', 50, 3000, 1)
INSERT [dbo].[SanPham] ([MaSP], [MaNhom], [TenSP], [MaDVT], [SLDK], [GTDK], [TrangThai]) VALUES (N'SP02', N'MNNU', N'Nước bò húc', N'Lon', 55, 10000, 1)
INSERT [dbo].[SanPham] ([MaSP], [MaNhom], [TenSP], [MaDVT], [SLDK], [GTDK], [TrangThai]) VALUES (N'SP03', N'MNNU', N'Nước CocaCola', N'Lon', 60, 6000, 1)
INSERT [dbo].[SanPham] ([MaSP], [MaNhom], [TenSP], [MaDVT], [SLDK], [GTDK], [TrangThai]) VALUES (N'SP04', N'MNNL', N'Bột cafe', N'Kg', 12, 120000, 1)
INSERT [dbo].[SanPham] ([MaSP], [MaNhom], [TenSP], [MaDVT], [SLDK], [GTDK], [TrangThai]) VALUES (N'SP05', N'MNNL', N'Đường', N'Kg', 14, 12000, 1)
INSERT [dbo].[SanPham] ([MaSP], [MaNhom], [TenSP], [MaDVT], [SLDK], [GTDK], [TrangThai]) VALUES (N'SP06', N'MNNL', N'Muối', N'kg', 100, 5000, 1)
INSERT [dbo].[SanPham] ([MaSP], [MaNhom], [TenSP], [MaDVT], [SLDK], [GTDK], [TrangThai]) VALUES (N'SP07', N'MNAU', N'Cam', N'kg', 3, 35000, 1)
INSERT [dbo].[SanPham] ([MaSP], [MaNhom], [TenSP], [MaDVT], [SLDK], [GTDK], [TrangThai]) VALUES (N'SP08', N'MNCB', N'Ổi', N'Kg', 4, 15000, 1)
INSERT [dbo].[SanPham] ([MaSP], [MaNhom], [TenSP], [MaDVT], [SLDK], [GTDK], [TrangThai]) VALUES (N'SP09', N'MNCB', N'Nho', N'Kg', 5, 13000, 1)
INSERT [dbo].[SanPham] ([MaSP], [MaNhom], [TenSP], [MaDVT], [SLDK], [GTDK], [TrangThai]) VALUES (N'SP10', N'MNDV', N'Thuốc lá 333', N'Bao', 12, 150000, 1)
INSERT [dbo].[SanPham] ([MaSP], [MaNhom], [TenSP], [MaDVT], [SLDK], [GTDK], [TrangThai]) VALUES (N'SP11', N'MNCF', N'Cafe Sữa', N'Ly', 999, 12000, 1)
INSERT [dbo].[SanPham] ([MaSP], [MaNhom], [TenSP], [MaDVT], [SLDK], [GTDK], [TrangThai]) VALUES (N'SP12', N'MNCF', N'Cafe Đen', N'Ly', 798, 11000, 1)
INSERT [dbo].[SanPham] ([MaSP], [MaNhom], [TenSP], [MaDVT], [SLDK], [GTDK], [TrangThai]) VALUES (N'SP13', N'MNCF', N'Cafe Latte', N'Ly', 899, 15000, 1)
INSERT [dbo].[SanPham] ([MaSP], [MaNhom], [TenSP], [MaDVT], [SLDK], [GTDK], [TrangThai]) VALUES (N'SP14', N'MNCF', N'Americano', N'Ly', 999, 18000, 1)
INSERT [dbo].[TaiKhoan] ([MaNV], [TaiKhoan], [MatKhau]) VALUES (N'NV01', N'Quang     ', N'a         ')
INSERT [dbo].[TaiKhoan] ([MaNV], [TaiKhoan], [MatKhau]) VALUES (N'NV02', N'NV02      ', N'1         ')
INSERT [dbo].[TaiKhoan] ([MaNV], [TaiKhoan], [MatKhau]) VALUES (N'NV03', N'NV03      ', N'g15hm55   ')
INSERT [dbo].[TaiKhoan] ([MaNV], [TaiKhoan], [MatKhau]) VALUES (N'NV04', N'NV04      ', N'fdfgh1    ')
INSERT [dbo].[TaiKhoan] ([MaNV], [TaiKhoan], [MatKhau]) VALUES (N'NV05', N'NV05      ', N'ftruhh7   ')
INSERT [dbo].[TaiKhoan] ([MaNV], [TaiKhoan], [MatKhau]) VALUES (N'NV06', N'NV06      ', N'2542g     ')
INSERT [dbo].[TaiKhoan] ([MaNV], [TaiKhoan], [MatKhau]) VALUES (N'NV07', N'NV07      ', N'jkfhs4754 ')
INSERT [dbo].[TaiKhoan] ([MaNV], [TaiKhoan], [MatKhau]) VALUES (N'NV08', N'NV08      ', N'tghthjyh5 ')
INSERT [dbo].[TaiKhoan] ([MaNV], [TaiKhoan], [MatKhau]) VALUES (N'NV09', N'NV09      ', N'jl54      ')
INSERT [dbo].[TaiKhoan] ([MaNV], [TaiKhoan], [MatKhau]) VALUES (N'NV10', N'NV10      ', N'hdsgjhdjg ')
INSERT [dbo].[TaiKhoan] ([MaNV], [TaiKhoan], [MatKhau]) VALUES (N'NV99', N'Admin     ', N'a         ')
ALTER TABLE [dbo].[BangGia]  WITH CHECK ADD  CONSTRAINT [FK_BangGia_LoaiBangGia1] FOREIGN KEY([MaBG])
REFERENCES [dbo].[LoaiBangGia] ([MaBG])
GO
ALTER TABLE [dbo].[BangGia] CHECK CONSTRAINT [FK_BangGia_LoaiBangGia1]
GO
ALTER TABLE [dbo].[BangGia]  WITH CHECK ADD  CONSTRAINT [FK_BangGia_SanPham] FOREIGN KEY([MaSP])
REFERENCES [dbo].[SanPham] ([MaSP])
GO
ALTER TABLE [dbo].[BangGia] CHECK CONSTRAINT [FK_BangGia_SanPham]
GO
ALTER TABLE [dbo].[BanPhong]  WITH CHECK ADD  CONSTRAINT [FK_BanPhong_KhuVuc1] FOREIGN KEY([MaKV])
REFERENCES [dbo].[KhuVuc] ([MaKV])
GO
ALTER TABLE [dbo].[BanPhong] CHECK CONSTRAINT [FK_BanPhong_KhuVuc1]
GO
ALTER TABLE [dbo].[ChungTu]  WITH CHECK ADD  CONSTRAINT [FK_ChungTu_BanPhong1] FOREIGN KEY([SoBan])
REFERENCES [dbo].[BanPhong] ([SoBan])
GO
ALTER TABLE [dbo].[ChungTu] CHECK CONSTRAINT [FK_ChungTu_BanPhong1]
GO
ALTER TABLE [dbo].[ChungTu]  WITH CHECK ADD  CONSTRAINT [FK_ChungTu_KhachHang1] FOREIGN KEY([MaKH])
REFERENCES [dbo].[KhachHang] ([MaKH])
GO
ALTER TABLE [dbo].[ChungTu] CHECK CONSTRAINT [FK_ChungTu_KhachHang1]
GO
ALTER TABLE [dbo].[ChungTu]  WITH CHECK ADD  CONSTRAINT [FK_ChungTu_NhanVien1] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[ChungTu] CHECK CONSTRAINT [FK_ChungTu_NhanVien1]
GO
ALTER TABLE [dbo].[DongCT]  WITH CHECK ADD  CONSTRAINT [FK_DongCT_ChungTu] FOREIGN KEY([SoCT])
REFERENCES [dbo].[ChungTu] ([SoCT])
GO
ALTER TABLE [dbo].[DongCT] CHECK CONSTRAINT [FK_DongCT_ChungTu]
GO
ALTER TABLE [dbo].[DongCT]  WITH CHECK ADD  CONSTRAINT [FK_DongCT_SanPham] FOREIGN KEY([MaSP])
REFERENCES [dbo].[SanPham] ([MaSP])
GO
ALTER TABLE [dbo].[DongCT] CHECK CONSTRAINT [FK_DongCT_SanPham]
GO
ALTER TABLE [dbo].[DVTKhac]  WITH CHECK ADD  CONSTRAINT [FK_DVTKhac_SanPham] FOREIGN KEY([MaSP])
REFERENCES [dbo].[SanPham] ([MaSP])
GO
ALTER TABLE [dbo].[DVTKhac] CHECK CONSTRAINT [FK_DVTKhac_SanPham]
GO
ALTER TABLE [dbo].[KhachHang]  WITH CHECK ADD  CONSTRAINT [FK_KhachHang_NhomKhach1] FOREIGN KEY([MaNhom])
REFERENCES [dbo].[NhomKhach] ([MaNhom])
GO
ALTER TABLE [dbo].[KhachHang] CHECK CONSTRAINT [FK_KhachHang_NhomKhach1]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_BoPhan1] FOREIGN KEY([MaBP])
REFERENCES [dbo].[BoPhan] ([MaBP])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_BoPhan1]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_TaiKhoan] FOREIGN KEY([MaNV])
REFERENCES [dbo].[TaiKhoan] ([MaNV])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_TaiKhoan]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_DonViTinh1] FOREIGN KEY([MaDVT])
REFERENCES [dbo].[DonViTinh] ([MaDVT])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_DonViTinh1]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_NhomHang1] FOREIGN KEY([MaNhom])
REFERENCES [dbo].[NhomHang] ([MaNhom])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_NhomHang1]
GO
ALTER TABLE [dbo].[ThanhPhan]  WITH CHECK ADD  CONSTRAINT [FK_ThanhPhan_SanPham] FOREIGN KEY([MaSP])
REFERENCES [dbo].[SanPham] ([MaSP])
GO
ALTER TABLE [dbo].[ThanhPhan] CHECK CONSTRAINT [FK_ThanhPhan_SanPham]
GO
