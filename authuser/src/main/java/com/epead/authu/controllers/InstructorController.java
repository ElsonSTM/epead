package com.epead.authu.controllers;

import com.epead.authu.dtos.InstructorDto;
import com.epead.authu.enums.UserType;
import com.epead.authu.models.UserModel;
import com.epead.authu.services.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;



@Log4j2
@RestController
@CrossOrigin(origins = "*", maxAge = 3600) //permitir o acesso de tds as origens
@RequestMapping("/instructors")
public class InstructorController {

    @Autowired
    UserService userService;

    @PostMapping("/subscription")
    public ResponseEntity<Object> saveSubscriptionInstructor(@RequestBody @Valid InstructorDto instructorDto){
        Optional<UserModel> userModelOptional = userService.findById(instructorDto.getUserId());
        if(!userModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        } else {
            var userModel = userModelOptional.get();
            userModel.setUserType(UserType.INSTRUCTOR);
            userModel.setLastUpdateDate(LocalDateTime.now(ZoneId.of("UTC")));
            userService.updateUser(userModel);

            return ResponseEntity.status(HttpStatus.OK).body(userModel);
        }
    }
}
