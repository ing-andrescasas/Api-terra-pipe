// package com.terrapipe.app.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.terrapipe.app.model.services.TerraPipeServiceIface;

// @RestController
// @RequestMapping("/hardware_profile")
// public class HardwareProfile {
//     @Autowired
//     private TerraPipeServiceIface terraService;

//     @GetMapping("/all")
//     public ResponseEntity<List<HardwareProfile>> allHardwareProfile() {
//         return ResponseEntity.ok(terraService.allHardwareProfile());
//     }

    
//     @GetMapping("/{id}")
//     public ResponseEntity<HardwareProfile> findHardwareProfile(@PathVariable Integer id){
//         return ResponseEntity.ok(terraService.findHardwareProfileById(id));
//     }

//     @PostMapping("/create")
//     public ResponseEntity<HardwareProfile> createHardwareProfile(@RequestBody HardwareProfile hardwareProfile) {
//         HardwareProfile hardwareProfileCreated = terraService.saveHardwareProfile(hardwareProfile);
//         return  ResponseEntity.ok(hardwareProfileCreated);
//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<HardwareProfile> deleteHardwareProfile(@PathVariable Integer id)  {

//         HardwareProfile hardwareProfileDelete = terraService.findHardwareProfileById(id);
//         terraService.deleteHardwareProfileById(id);;
//         return ResponseEntity.ok( hardwareProfileDelete);
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<HardwareProfile> editHardwareProfile(@PathVariable Integer id, @RequestBody  HardwareProfile hardwareProfile) {
//         HardwareProfile hardwareProfileExist = terraService.findHardwareProfileById(id);
//             terraService.updateHardwareProfile(hardwareProfileardwareProfileExist);
//             return ResponseEntity.ok(hardwareProfileExist);

//     }
// }
