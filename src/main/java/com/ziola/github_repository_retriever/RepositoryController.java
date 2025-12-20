package com.ziola.github_repository_retriever;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/github/users")
class RepositoryController {
    private final RepositoryService service;

    RepositoryController(RepositoryService service) {
        this.service = service;
    }

    @GetMapping("/{username}")
    List<RepositoryDto> getUserRepositoriesWithBranches(@PathVariable String username) {
        return service.getUserRepositories(username);
    }
}
