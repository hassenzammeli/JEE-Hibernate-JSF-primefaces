package test;

import util.HibernateUtil;

/**
 *
 * @author hassen-zammeli
 */
public class Test {

    public static void main(String[] args) {
        HibernateUtil.getSessionFactory().openSession();
    
    }

}
