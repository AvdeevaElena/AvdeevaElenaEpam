package SE07;

public interface Accaunt {
    void setAmount(Integer integer);
    boolean halfTransmitToAccount(String who, Integer howMuch);
    Integer lookForAccountNameBalance(String accountNameBalance);
    Integer showMeBalance();
    boolean rollBackChanges();
    void saveTransaction();

}
