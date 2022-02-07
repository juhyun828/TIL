import dto.AddressDTO;
import dto.CustomerAddressDTO;
import dto.CustomerDTO;
import entity.Address;
import entity.Customer;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Customer> customers = new ArrayList<Customer>();
        List<Address> addresses = new ArrayList<Address>();

        customers.add(new Customer(1, "customer1", 11));
        customers.add(new Customer(2, "customer2", 11));
        customers.add(new Customer(3, "customer3", 22));
        customers.add(new Customer(4, "customer4", 22));
        customers.add(new Customer(5, "customer5", 33));

        addresses.add(new Address(11, "city1", "state1"));
        addresses.add(new Address(22, "city2", "state2"));
        addresses.add(new Address(33, "city3", "state3"));

        System.out.println(leftJoin(customers, addresses));

        System.out.println("##############################################");

        System.out.println(join(customers, addresses));

    }

    public static List<CustomerDTO> leftJoin(List<Customer> customers,
                                             List<Address> addresses) {

        Map<Integer, Address> aidAddress = addresses.stream()
                .collect(Collectors.toMap( a -> a.getAid(), a -> a ));

//        Map<Integer, Address> aidAddress2 = addresses.stream()
//                .collect(Collectors.toMap( Address::getAid, Function.identity() ));

        List<CustomerDTO> customerDTOS = customers.stream()
                .map( customer -> {

                    CustomerDTO customerDTO = new CustomerDTO();
                    customerDTO.setCid( customer.getCid() );
                    customerDTO.setName( customer.getName() );

                    if ( aidAddress.containsKey( customer.getAid() ) ) {

                        Address address = aidAddress.get( customer.getAid() );

                        AddressDTO addressDTO = new AddressDTO();
                        addressDTO.setAid( address.getAid() );
                        addressDTO.setCity( address.getCity() );
                        addressDTO.setState( address.getState() );

                        customerDTO.setAddress( addressDTO );

                    }

                    return customerDTO;

                } )
                .collect(Collectors.toList());

        return customerDTOS;
    }

    public static List<CustomerAddressDTO> join(List<Customer> customers,
                                             List<Address> addresses) {

            List<CustomerAddressDTO> customerAddressDTOS =
                    customers.stream().flatMap( customer -> addresses.stream()
                                                                    .map( address -> {
                                                                        CustomerAddressDTO customerAddressDTO = new CustomerAddressDTO();

                                                                        customerAddressDTO.setCid( customer.getCid() );
                                                                        customerAddressDTO.setName( customer.getName() );
                                                                        customerAddressDTO.setAid( customer.getAid() );

                                                                        customerAddressDTO.setAaid( address.getAid() );
                                                                        customerAddressDTO.setCity( address.getCity() );
                                                                        customerAddressDTO.setState( address.getState() );

                                                                        return customerAddressDTO;

                                                                    } ) )
                            .filter( customerAddressDTO -> customerAddressDTO.getAid().equals( customerAddressDTO.getAaid() ) )
                            .collect(Collectors.toList());

        return customerAddressDTOS;
    }
}
