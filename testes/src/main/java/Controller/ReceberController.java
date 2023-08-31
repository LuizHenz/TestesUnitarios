package Controller;

import DTO.ReceberDTO;
import Entity.Calculos;
import Service.ReceberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api")
public class ReceberController {

    @Autowired
    private ReceberService receberService;

    private Calculos calculos;


    @PostMapping("/send")
    public ResponseEntity<?> mandar(@RequestBody ReceberDTO receberDTO){
        try{
            calculos = this.receberService.verify(receberDTO);
            System.out.println(receberDTO.getNumeroList());
            return ResponseEntity.ok(calculos);
        }catch (Exception error){
            return ResponseEntity.badRequest().body("Error" + error.getMessage());
        }

    }
}