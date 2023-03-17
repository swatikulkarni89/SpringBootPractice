package com.example.test1.controller;

import com.example.test1.Repo1.ActorRepo;
import com.example.test1.Repo1.AddressRepo;
import com.example.test1.Repo1.CustomerRepo;
//import com.example.test1.Service1.Output;
import com.example.test1.Service1.Output;
import com.example.test1.Service2.UploadFileService;
import com.example.test1.domenModel.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class testController {
    @Autowired
    AddressRepo userRepository;

    @Autowired
    private ActorRepo actorRepo;
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    CustomerAddress customerAddress;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    UploadFileService uploadFileService;
@Autowired
Output output;
FileWriter writer=new FileWriter("D:\\projects\\spring_boot\\test1\\test1\\output.txt");

    public testController() throws IOException {
    }

    @GetMapping
    public List<Address> findAllUsers() {
        return (List<Address>) userRepository.findAll();
    }



    @GetMapping("/customer/{id}")
    public ResponseEntity<Object> customerFindById(@PathVariable(value = "id") Integer id) {
        Optional<Customer>  customer1 = customerRepo.findById(id);

        if (customer1.isPresent()) {
            System.out.println("User : " + customer1.get());
            return ResponseEntity.ok().body(customer1.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
//    @GetMapping("/list/customerAddress/{id}")
//    public ResponseEntity<Object>  customerAddressFindById(@PathVariable(value = "id") int address_id){
//
//         CustomerAddress customerAddress1= getCustomerAddressByMapper(address_id);
//
//         //CustomerAddress(address_id);
//
//        System.out.println("list "+customerAddress1);
//
//        if (customerAddress1 != null) {
//            System.out.println("User : " + customerAddress1);
//            return ResponseEntity.ok().body(customerAddress1);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//
//    }
@GetMapping("/list/customerAddress/{id}")
    public ResponseEntity<Object>  customerAddressFindById(@PathVariable(value = "id") int address_id){

    CustomerAddress customerAddress1= getcustomerAddress(address_id);
        System.out.println("list "+customerAddress1);

        if (customerAddress1 != null) {
            System.out.println("User : " + customerAddress1);
            return ResponseEntity.ok().body(customerAddress1);
        } else {
            return ResponseEntity.notFound().build();
        }


    }



    @GetMapping("/{id}")
    public ResponseEntity<Object> findUserById(@PathVariable(value = "id") int address_id) {
        Optional<Address> user = userRepository.findById(address_id);

        if (user.isPresent()) {
            System.out.println("User : " + user.get());
            return ResponseEntity.ok().body(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    /*@GetMapping("filmInfo/{id}")
    public String filmInfoOfAnActor(@PathVariable(value = "id") int actor_id) {
        //List<FilmDetailsForAnActor> filminfo = filmDetailsForAnActorRepo.findInfoByQuery(actor_id);
*//*
        if (filminfo.isEmpty()==false) {
            System.out.println("User : " + filminfo.toString());
            return ResponseEntity.ok().body(filminfo.toString());
        } else {
            return ResponseEntity.notFound().build();
        }*//*
        return "it will be executing";
    }*/

    @GetMapping("/listOfActors")
    public ArrayList<Actor> actorlist() {
        ArrayList<Actor> actors = (ArrayList<Actor>) actorRepo.findAll();
        return (actors);
    }
    public CustomerAddress getcustomerAddress(int address_id) {

        Address address = userRepository.getById(address_id);
        Customer customer = customerRepo.getReferenceById(address_id);
        customerAddress.setAddress_id(address_id);
        customerAddress.setAddress(address.getAddress());
        customerAddress.setAddress2(address.getAddress2());
        customerAddress.setActive(customer.getActive());
        customerAddress.setFirst_name(customer.getFirst_name());
        customerAddress.setLast_name(customer.getLast_name());
        customerAddress.setEmail(customer.getEmail());


return customerAddress;
    }


    public List<CustomerAddress> getCustomerAddressByMapper(int address_id) {
        Address address = userRepository.getById(address_id);
        Customer customer = customerRepo.getReferenceById(address_id);

        CustomerAddress
            customerAddress=this.modelMapper.map(customer,CustomerAddress.class);
        CustomerAddress customerAddress1=this.modelMapper.map(address,CustomerAddress.class);
        List<CustomerAddress> list=new ArrayList<>();
        list.add(customerAddress);
        list.add(customerAddress1);
        return list;
    }

    @GetMapping("/list/customerAddressService1/{id}")
    public ResponseEntity<Object>  customerAddressbyService1(@PathVariable(value = "id") int address_id) throws IOException {
           // Output output=new Output();
        List<CustomerAddress> customerAddress1=output.getOutput(address_id);

        if (customerAddress1 != null) {
            System.out.println("User : " + customerAddress1);
            PrintWriter out = new PrintWriter(writer);
            out.write(customerAddress1.toString());
            out.close();
            uploadFileService.uploadFile();

            return ResponseEntity.ok().body(customerAddress1);

            // Write the API output to the file


        } else {
            return ResponseEntity.notFound().build();
        }


    }

}