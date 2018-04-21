package SE07;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Transaction implements  Accaunt{

    private static String user    = "user";
    private static String name    = "name";
    private static String balance = "balance";
    private static File accountFileXML;
    private static Integer startStateAccountBeforetransact       = 0;
    private static Integer startStateAccountBeforetransactBackUp = 0;
    private static DocumentBuilderFactory documentBuilderFactory;
    private static DocumentBuilder        documentBuilder;
    private static Document               document;
    private static Node                   coreNodeAccounts;
    private static Node                   userNode;
    private static Node                   balance1Node;
    private static Node                   balance2Node;
    private static Element                coreElement;
    private static Element                userElement;
    private static Element                user2Element;
    private static Element                balance1Element;
    private static Element                balance2Element;
    private static String                 accountElementName;
    private static NodeList               usersnodeList;


    public Transaction(String name) {
        this.name = name;
       accountFileXML = new File("acc");
      //  accountFileXML = new File("account2t.txt");



        try {
            documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(accountFileXML);
            document.getDocumentElement()
                    .normalize();

            coreNodeAccounts = document.getFirstChild();

            usersnodeList = document.getElementsByTagName("user");
            if (testUserExists(name, usersnodeList)) {
                startStateAccountBeforetransact = Integer.parseInt(userElement.getElementsByTagName("balance")
                        .item(0)
                        .getChildNodes()
                        .item(0)
                        .getNodeValue());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private boolean testUserExists(String name, NodeList usersnodeList) {
        boolean result = false;
        for (int usersListIndex = 0; usersListIndex < usersnodeList.getLength(); usersListIndex++) {
            Node    node    = usersnodeList.item(usersListIndex);
            Element element = (Element) node;
            String testUserName = element.getElementsByTagName("name")
                    .item(0)
                    .getChildNodes()
                    .item(0)
                    .getNodeValue();
            if (testUserName.equals(name)) {
                result = true;
                userElement = element;
            }
        }
        return result;
    }

    public String getname() {
        return name;
    }


    @Override public synchronized void setAmount(Integer integer) {
        this.startStateAccountBeforetransact = integer;
    }

    @Override public synchronized boolean halfTransmitToAccount(String who, Integer howMuch) {
        boolean result = false;

        if (testUserExists(who, getUsersnodeList())) {
            for (int usersListIndex = 0; usersListIndex < usersnodeList.getLength(); usersListIndex++) {
                Node    node    = usersnodeList.item(usersListIndex);
                Element element = (Element) node;
                String testUserName = element.getElementsByTagName("name")
                        .item(0)
                        .getChildNodes()
                        .item(0)
                        .getNodeValue();
                if (testUserName.equals(name)) {

                    Integer balanceNow = Integer.parseInt(element.getElementsByTagName("balance")
                            .item(0)
                            .getChildNodes()
                            .item(0)
                            .getNodeValue());
                    if ((balanceNow + howMuch) > 0) {
                        result = true;
                        NamedNodeMap namedNodeMap = node.getAttributes();
                        Node         nodeAttr     = namedNodeMap.getNamedItem("balance");
                        nodeAttr.setTextContent(balanceNow + howMuch + "");
                    }
                }
            }
        }


        return result;
    }

    public static NodeList getUsersnodeList() {
        return usersnodeList;
    }

    @Override public synchronized Integer lookForAccountNameBalance(String accountBalanceName) {
        return startStateAccountBeforetransact =
                startStateAccountBeforetransactBackUp = Integer.parseInt(
                        userElement.getElementsByTagName("balance")
                                .item(0)
                                .getNodeValue());
    }


    @Override public synchronized Integer showMeBalance() {
        return startStateAccountBeforetransact;
    }

    @Override public synchronized boolean rollBackChanges() {
        boolean result = false;
        return result;
    }


    @Override public synchronized void saveTransaction() {

    }
}


