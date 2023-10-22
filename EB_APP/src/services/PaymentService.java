package services;

import daoImplementaion.PaymentDAOImp;
import entities.Operation;
import entities.Payment;

public class PaymentService {

    public  PaymentDAOImp paymentDAOImp;

    public PaymentService(PaymentDAOImp instance) {
        paymentDAOImp = instance;
    }

    public  Operation saveForCA(Payment payment) {

        return paymentDAOImp.saveForCA(payment).orElse(null);

    }

    public  Operation saveForSA(Payment payment) {

        return paymentDAOImp.saveForSA(payment).orElse(null);

    }

    public  boolean delete(String number) {

        return paymentDAOImp.delete(number);
    }

    public  Operation findByNumber(String number) {

        return paymentDAOImp.findByNumber(number).orElse(null);

    }

}
