

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class A {
	public static void main(String[] args) throws Exception {
		 Random random = new Random();
		 Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2018-11-12");
	     List<Date> dateMis = getDayMi(date);
		String[] ens={"e_l","e_pv","e_e","e_crt"};
		String[] umids={
				"001","002","003","004","005","006","007","008","009","010",
				"011","012","013","014","015","016","017","018","019","020",
				"021","022","023","024","025","026","027","028","029","030",
				"031","032","033","034","035","036","037","038","039","040",
				"041","042","043","044","045","046","047","048","049","050",
				};
		for (Date dateMi : dateMis) {
			long  dateTime =  dateMi.getTime();
			String uud = getUUId();
			String usd = getUUId();
			String oid = getUUId();	
			String umid =umids[random.nextInt(50)];
			for(String en : ens){
				StringBuffer sb = new StringBuffer();
				sb.append("58.49.22.234^A")
				.append(dateTime/1000+".000")
				.append("^Ahh^A")
				.append("/BfImg.gif?")
				.append("en=");
				if(en.equals("e_l")){
					sb.append("e_l");
				}else if(en.equals("e_pv")){
					sb.append("e_pv")
					.append("&p_url=http%3A%2F%2Flocalhost%3A8080%2Fbf_track_jssdk%2Fdemo4.jsp")
					.append("&p_ref=http%3A%2F%2Flocalhost%3A8080%2Fbf_track_jssdk%2Fdemo.jsp")
					.append("&tt=%E6%B5%8B%E8%AF%95%E9%A1%B5%E9%9D%A24");
				}else if(en.equals("e_e")){
					sb.append("e_e")
					.append("&ca=%E8%AE%A2%E5%8D%95%E4%BA%8B%E4%BB%B6")
					.append("&ac=%E8%AE%A2%E5%8D%95%E4%BA%A7%E7%94%9F");
				}else if(en.equals("e_crt")){
					sb.append("e_crt")
					.append("&oid=").append(oid)
					.append("&on=%E8%AE%A2%E5%8D%952")
					.append("&cua=54.2")
					.append("&cut=RMB")
					.append("&pt=weixinpay");
				}
				sb.append("&ver=1&pl=website&sdk=js")
				.append("&u_ud=").append(uud)
				.append("&u_mid=").append(umid)
				.append("&u_sd=").append(usd)
				.append("&c_time=").append(dateTime+"")
				.append("&l=zh-CN")
				.append("&b_iev=Mozilla%2F5.0%20(Windows%20NT%206.1%3B%20WOW64)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)%20Chrome%2F46.0.2490.71%20Safari%2F537.36")
				.append("&b_rst=1280*768");	
				System.out.println(sb.toString());			
			}
		}
	}
	public static String  getUUId(){
		return UUID.randomUUID().toString().replace("-", "");
	}
    private static List<Date> getDayMi(Date date) {
        Calendar tt = Calendar.getInstance();
        tt.setTime(date);
        Calendar t2 = Calendar.getInstance();
        t2.setTime(date);
        t2.add(Calendar.DAY_OF_MONTH, 1);
        List<Date> dateList = new ArrayList<Date>();
        for (;tt.compareTo(t2)<0; tt.add(Calendar.MINUTE, 1)) {
            dateList.add(tt.getTime());
        }
        return dateList;
    }
}
