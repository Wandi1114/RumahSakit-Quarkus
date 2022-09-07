package utils;


import io.quarkus.elytron.security.common.BcryptUtil;
import org.wildfly.security.password.Password;
import org.wildfly.security.password.PasswordFactory;
import org.wildfly.security.password.WildFlyElytronPasswordProvider;
import org.wildfly.security.password.interfaces.BCryptPassword;
import org.wildfly.security.password.util.ModularCrypt;

import java.security.NoSuchAlgorithmException;

public class SecurityUtil {
    private String secretKey = "rumah sakit anjay";
    public static void main(String[] args) throws Exception{
        String coba = hash("123456");
//        String hased = BcryptUtil.bcryptHash()
        String input = "1234568";
        System.out.println(coba);
        System.out.println(input);
        System.out.println(BcryptUtil.matches(input,coba));
    }
//    public static boolean verify(String hashedPass, String pass){
//        WildFlyElytronPasswordProvider provider = new WildFlyElytronPasswordProvider();
//
//        try{
//            PasswordFactory passFactory = PasswordFactory.getInstance(BCryptPassword.ALGORITHM_BCRYPT, provider);
//        }catch (NoSuchAlgorithmException e){
//            return false;
//        }
//
//        Password userPass = ModularCrypt.decode(hashedPass);
//
//        Password userRestored = passFactory.translate(userPass);
//
//        return passFactory.verify(userRestored, pass.toCharArray());
//
//
//    }
    public static String hash(String pass){
        return BcryptUtil.bcryptHash(pass);
    }
}
