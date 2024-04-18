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
// @RequestMapping("/hardware_categories")
// public class HardwareCategory{
//     @Autowired
//     private TerraPipeServiceIface terraService;

//     @GetMapping("/all")
//     public ResponseEntity<List<HardwareCategory>> allHardwareCategory() {
//         return ResponseEntity.ok(terraService.allHardwareCategory());
//     }

    
//     @GetMapping("/{id}")
//     public ResponseEntity<HardwareCategory> findHardwareCategory(@PathVariable Integer id){
//         return ResponseEntity.ok(terraService.findHardwareCategoryById(id));
//     }

//     @PostMapping("/create")
//     public ResponseEntity<HardwareCategory> createHardwareCategory(@RequestBody HardwareCategory hardwareCategory) {
//         HardwareCategory hardwareCategoryCreated = terraService.saveHardwareCategory(hardwareCategory);
//         return  ResponseEntity.ok(hardwareCategoryCreated);
//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<HardwareCategory> deleteHardwareCategory(@PathVariable Integer id)  {

//         HardwareCategory hardwareCategoryDelete = terraService.findHardwareCategoryById(id);
//         terraService.deleteHardwareCategoryById(id);;
//         return ResponseEntity.ok( hardwareCategoryDelete);
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<HardwareCategory> editHardwareCategory(@PathVariable Integer id, @RequestBody  HardwareCategory hardwareCategory) {
//         HardwareCategory hardwareCategoryExist = terraService.findHardwareCategoryById(id);
//             terraService.updateCity(hardwareCategoryExist);
//             return ResponseEntity.ok(hardwareCategoryExist);

//     }
// }
