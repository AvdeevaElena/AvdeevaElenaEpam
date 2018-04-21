package SE07;
//В текстовом (или xml) файле содержится информация о переводах средств со счета на
//        счет. Создайте приложение, позволяющее в параллельном режиме обработать эту информацию
//        (счета с приложении представляются собой объекты). Синхронизируйте код приложения
//        используя ключевое слово synchronized (1 вариант) и библиотеку java.util.concurrent (2 вариант).
public class Bank {


    public static synchronized boolean isTransfer(Transaction monyTransfering1,
                                                             Transaction monyTransfering2,
                                                             Integer sum) {
        boolean result = false;
        if (monyTransfering1.halfTransmitToAccount(monyTransfering1.getname(), ((-1) * sum))) {

            if (monyTransfering1.halfTransmitToAccount(monyTransfering1.getname(), sum)) {
                result = true;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Transaction fromUser = new Transaction("user1");
        Transaction toUser   = new Transaction("user2");
        Integer         money    = 50;
        if (isTransfer(fromUser, toUser, money)) {
            System.out.println("succes");
        } else {
            System.out.println("no transaction");

        }
    }

}
