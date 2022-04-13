package com.myStudent.StudentMainController.StudentMessageController;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;


    @RestController
    @RequestMapping(path = "api/v1/student")

public class MessageController {
        private final WellcomeMessage WellcomeMessage;

    @Autowired
    public MessageController (WellcomeMessage WellcomeMessage) {
       this.WellcomeMessage = WellcomeMessage;
    }

    @GetMapping(path = "/home")
    public ResponseEntity<String> homePage() {
        return new ResponseEntity<>(
                WellcomeMessage.Greetings(),
                HttpStatus.OK
        );

        @PostMapping(path = "/create")
        public ResponseEntity<String> registerNewStudent(@RequestBody Student student) {

            WellcomeMessage.addNewStudent(student);

            return new ResponseEntity<>(
                    "Successfully created",
                    HttpStatus.CREATED
            );
        }
    }
}

