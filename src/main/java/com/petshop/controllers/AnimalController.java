package com.petshop.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.petshop.model.Animal;
import com.petshop.services.AnimalService;

@Controller
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @Value("${imagens.animais.path}")
    private String imagesPath;

    @GetMapping("/animais")
    public String listarAnimais(Model model) {
        model.addAttribute("animais", animalService.buscarTodosOsAnimais());
        return "animais/lista";
    }

    @GetMapping("/animais/cadastro")
    public String exibirFormularioCadastro() {
        return "animais/cadastro";
    }

    @GetMapping("/animais/editar/{id}")
    public String editarAnimal(@PathVariable Long id, Model model) {
        Animal animal = animalService.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("animal", animal);
        return "animais/editar";
    }

    @PostMapping("/animais/editar/{id}")
    public String atualizarAnimal(@PathVariable Long id, @ModelAttribute Animal animalAtualizado) {
        Animal animal = animalService.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        animal.setNome(animalAtualizado.getNome());
        animal.setRaca(animalAtualizado.getRaca());
        animal.setIdade(animalAtualizado.getIdade());
        animalService.salvarAnimal(animal);
        return "redirect:/animais";
    }

    @GetMapping("/animais/deletar/{id}")
    public String deletarAnimal(@PathVariable Long id) {
        animalService.excluirAnimalPorId(id);
        return "redirect:/animais";
    }

    // Podemos salvar sem a foto por isso verificamos se a foto veio vazia com o
    // método isEmpty()
    @PostMapping("/animais")
    public String salvarAnimal(@ModelAttribute Animal animal, @RequestParam("foto") MultipartFile foto)
            throws IOException {
        if (!foto.isEmpty()) {
            String nomeArquivo = foto.getOriginalFilename(); // adicionar uma chave tipo data e hora
            Path caminho = Paths.get(imagesPath + nomeArquivo);
            Files.copy(foto.getInputStream(), caminho);
            animal.setFotoPath(caminho.toString());
        }
        animalService.salvarAnimal(animal);
        return "redirect:/animais";
    }

}