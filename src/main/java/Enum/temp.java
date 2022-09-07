package Enum;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class temp {
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-uuuu H:m:s");
    public static void main(String[] args) {
//        List<String> cek = new ArrayList<String>();
//        cek.add("APA");
//        cek.add("SIAPA");
//        cek.add("DIMANA");
//        System.out.println(cek);
//        String a = "APA";
//        System.out.println(cek.contains(a));
//
//        System.out.println((0+4)%4);
//        Date a = new Date();
//        LocalDateTime dt = LocalDateTime.now();
//        StringBuilder date = new StringBuilder();
//        date.append(dt.getDayOfMonth()+"-");
//        date.append(dt.getMonthValue()+"-");
//        date.append(dt.getYear()+" ");
//        date.append(dt.getHour()+":");
//        date.append(dt.getMinute()+":");
//        date.append(dt.getSecond());
//
//        System.out.println(date);
//        System.out.println(dt);
//        System.out.println(LocalDateTime.parse(date,formatter));
//        String hased = BcryptUtil.bcryptHash("superadmin2");
//        System.out.println(hased);
//        String pass = "superadmin2";
//        System.out.println(BcryptUtil.matches(pass, "$2a$10$RyAfruOoZjGoYa6ZsHkivubdb8nhSuhBs6ceWrzvjRJEV9gs6bdWq"));

//

    }
    public static String date2String(LocalDate date){
        return date.format(formatter);
    }

    public static LocalDate string2Date(String date){
        return LocalDate.parse(date,formatter);
    }
}
