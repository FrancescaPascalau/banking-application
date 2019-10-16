package francesca.pascalau.rest;

import francesca.pascalau.business.entity.TransferBusiness;
import francesca.pascalau.business.entity.TransferDeniedException;
import francesca.pascalau.business.service.api.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The Transfer Agent has the controller functionality for this application.
 * It handles a request with the transfer information and calls the transfer() method from the business module.
 * The request is mapped by a POST method.
 *
 * Tested in Postman:
 *      URL: http://localhost:1997/rest/v1/transfer
 *      JSON body:
 *      {
 * 	        "sender": "Salary",
 * 	        "receiver": "Savings",
 * 	        "amount": "1000"
 *      }
 */

@RestController
@RequestMapping("/rest/v1")
public class TransferAgent {

    @Autowired
    private TransferService transferService;

    @RequestMapping(value = "transfer", method = RequestMethod.POST)
    public ResponseEntity transfer(@RequestBody TransferBusiness transferBusiness) {
        try {
            transferService.transfer(transferBusiness);
        } catch (TransferDeniedException e) {
            return ResponseEntity.badRequest().body("Money transfer error: " + e.getMessage());
        }
        return ResponseEntity.ok("Money transfer completed successfully!");
    }
}
