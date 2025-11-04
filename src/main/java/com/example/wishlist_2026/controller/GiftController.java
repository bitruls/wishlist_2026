package com.example.wishlist_2026.controller;

import com.example.wishlist_2026.model.Gift;
import com.example.wishlist_2026.repository.GiftRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gifts")
@CrossOrigin(origins = "*")
public class GiftController {

    private final GiftRepository giftRepository;

    public GiftController(GiftRepository giftRepository) {
        this.giftRepository = giftRepository;
    }

    @GetMapping
    public List<Gift> getAll() {
        return giftRepository.findAll();
    }

    @GetMapping("/{id}")
    public Gift getOne(@PathVariable Long id) {
        return giftRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gift not found"));
    }

    @PostMapping
    public Gift create(@RequestBody Gift gift) {
        return giftRepository.save(gift);
    }

    @PutMapping("/{id}")
    public Gift update(@PathVariable Long id, @RequestBody Gift updated) {
        return giftRepository.findById(id)
                .map(g -> {
                    g.setItem(updated.getItem());
                    g.setDescription(updated.getDescription());
                    g.setPrice(updated.getPrice());
                    return giftRepository.save(g);
                })
                .orElseThrow(() -> new RuntimeException("Gift not found"));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        giftRepository.deleteById(id);
    }
}
