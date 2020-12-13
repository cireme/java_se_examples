package object_manipulation;

import object_manipulation.service.DateService;
import object_manipulation.service.ObjectService;

import java.text.ParseException;

public class ObjectApplication {

    public static void main(String[] args) throws ParseException {
        new ObjectService();
        new DateService();
    }
}
