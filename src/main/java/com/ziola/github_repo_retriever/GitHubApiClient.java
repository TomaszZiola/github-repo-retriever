package com.ziola.github_repo_retriever;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
class GitHubApiClient {
    private final RestClient restClient;

    GitHubApiClient(RestClient restClient) {
        this.restClient = restClient;
    }

    List<GitHubRepoResponse> getRepositories(String username) {
        return restClient.get()
                .uri("/users/{username}/repos", username)
                .retrieve()
                .onStatus(NOT_FOUND::equals, (_, _) -> {
                    throw new UserNotFoundException("User '" + username + "' not found");
                })
                .body(new ParameterizedTypeReference<>() {
                });
    }

    List<GitHubBranchResponse> getBranches(String username, String repoName) {
        return restClient.get()
                .uri("/repos/{username}/{repoName}/branches", username, repoName)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }
}
