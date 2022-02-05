```java
@Data
public class AddressDTO {
    private Integer aid;
    private String city;
    private String state;
}

@Data
public class CustomerDTO {
    private Integer cid;
    private String name;
    private AddressDTO address;
}

@Data
public class CustomerAddressDTO {
    private Integer cid;
    private String name;
    private Integer aid;
    private Integer aaid; //??
    private String city;
    private String state;
}
```

## Inner Join
```java
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
```

## Join (이걸 뭐라고 불러야..)
```java
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
```

[출처](https://stackoverflow.com/questions/57865058/left-join-using-java-stream-on-two-lists)