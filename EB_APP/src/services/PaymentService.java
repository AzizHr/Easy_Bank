package services;

import daoImplementaion.PaymentDAOImp;

public class PaymentService {

    public static PaymentDAOImp paymentDAOImp;

    public PaymentService(PaymentDAOImp instance) {
        paymentDAOImp = instance;
    }



}
