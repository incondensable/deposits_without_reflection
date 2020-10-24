package com.fanap.deposit.convertor;

import com.fanap.deposit.model.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class XmlConvertor implements Serializable {

    public static List<Deposit> convertXmlToDeposit(String depositFilePath) {

        List<Deposit> depositList = new ArrayList<>();

        try {
            File input = new File(depositFilePath);

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = dBuilder.parse(input);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("deposit");

            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Element element = (Element) nodeList.item(temp);

                String customerNumber = element.getElementsByTagName("customerNumber").item(0).getTextContent();
                BigDecimal balance = new BigDecimal(element.getElementsByTagName("depositBalance").item(0).getTextContent());
                String type = element.getElementsByTagName("depositType").item(0).getTextContent();
                Integer days = new Integer(element.getElementsByTagName("durationInDays").item(0).getTextContent());

                Deposit deposit = new Deposit
                        .Builder()
                        .setCustomerNumber(customerNumber)
                        .setDepositBalance(balance)
                        .setDepositType(type)
                        .setDurationInDays(days)
                        .build();

                depositList.add(deposit);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        depositList.sort(Comparator.comparing(Deposit::calculatePaidInterest).reversed());

        return depositList;
    }

}