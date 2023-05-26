package study;


public class ExceptionCheck {

    private static final String CONST_ROPPONGI_HILLS = "六本木ヒルズ";
    private static final String CONST_IMPERIAL_HOTEL = "帝国ホテル";

    public static void main(String args[]) {

        String hogeOffice = null;

        if (!hogeOffice.equals(CONST_IMPERIAL_HOTEL)) {
        	 throw new Exception("オフィスは帝国ホテルだよ。");
        	} else {
        	  // 例外でthrowされた以降の処理は実行されない
        	 System.out.println("hogeのオフィスは" + CONST_IMPERIAL_HOTEL + "です。");
        	}
    }}