package com.ziola.github_repository_retriever;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
class RepositoryService {
    private final GitHubApiClient client;

    RepositoryService(GitHubApiClient client) {
        this.client = client;
    }

    List<RepositoryDto> getUserRepositories(String username) {
        return client.getRepositories(username)
                .stream()
                .filter(repo -> !repo.fork())
                .map(repo -> {
                    var branches = client.getBranches(username, repo.name())
                            .stream()
                            .map(branch -> new BranchDto(branch.name(), branch.commit().sha()))
                            .toList();

                    return new RepositoryDto(repo.name(), repo.owner().login(), branches);
                })
                .toList();
    }
}
