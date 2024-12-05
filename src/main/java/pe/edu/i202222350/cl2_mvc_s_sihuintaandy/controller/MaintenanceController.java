package pe.edu.i202222350.cl2_mvc_s_sihuintaandy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.i202222350.cl2_mvc_s_sihuintaandy.dto.FilmDetailDto;
import pe.edu.i202222350.cl2_mvc_s_sihuintaandy.dto.FilmDto;
import pe.edu.i202222350.cl2_mvc_s_sihuintaandy.dto.FilmInsertDto;
import pe.edu.i202222350.cl2_mvc_s_sihuintaandy.entity.Language;
import pe.edu.i202222350.cl2_mvc_s_sihuintaandy.service.MaintenanceService;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/maintenance")

public class MaintenanceController {

    @Autowired
    MaintenanceService maintenanceService;

    @GetMapping("/start")
    public String start(Model model) {

        List<FilmDto> films = maintenanceService.findAllFilms();
        model.addAttribute("films", films);
        return "maintenance";
    }


    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        FilmDetailDto filmDetailDto = maintenanceService.findFilmById(id);

        model.addAttribute("film", filmDetailDto);
        return "maintenance_detail";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        FilmDetailDto filmDetailDto = maintenanceService.findFilmById(id);
        List<Language> languages = maintenanceService.getAllLanguages();

        List<String> specialFeaturesList = Arrays.asList(filmDetailDto.specialFeatures().split(",\s*"));
        model.addAttribute("film", filmDetailDto);
        model.addAttribute("languages", languages);
        model.addAttribute("specialFeaturesList", specialFeaturesList);
        return "maintenance_edit";
    }


    @PostMapping("/edit-confirm")
    public String editConfirm(@ModelAttribute FilmDetailDto filmDetailDto, Model model) {
        maintenanceService.updateFilm(filmDetailDto);
        return "redirect:/maintenance/start";
    }


    @GetMapping("/insert")
    public String insertFilmForm(Model model) {
        FilmInsertDto filmInsertDto = new FilmInsertDto(
                "",
                "",
                null,
                null,
                "",
                0,
                0.0,
                null,
                0.0,
                "",
                "",
                new Date()
        );

        List<Language> languages = maintenanceService.getAllLanguages();

        model.addAttribute("filmInsertDto", filmInsertDto);
        model.addAttribute("languages", languages);

        return "maintenance-insert";
    }

    @PostMapping("/insert")
    public String insertFilm(FilmInsertDto filmInsertDto) {
        maintenanceService.insertFilm(filmInsertDto);
        return "redirect:/maintenance/start";
    }

    @GetMapping("/delete/{id}")
    public String deleteFilm(@PathVariable Integer id) {
        maintenanceService.deleteFilmById(id);
        return "redirect:/maintenance/start";
    }
}

