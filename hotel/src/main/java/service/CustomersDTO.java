package service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomersDTO {

    private Long id;

    private String name;

    private String email;

    private String phone;

    private String address;

    private String cpf;

}
