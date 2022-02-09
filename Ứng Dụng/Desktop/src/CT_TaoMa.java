
import java.text.SimpleDateFormat;
import java.util.Date;


public class CT_TaoMa 
{
    Date ThoiGian;
    SimpleDateFormat DinhDang;
    String Ma;
    public String TaoHoaDon()
    {
        ThoiGian = new Date();
        DinhDang =  new SimpleDateFormat("yyyyMMddHHmmss");
        Ma = DinhDang.format(ThoiGian);
        return Ma.trim();
    }
}
