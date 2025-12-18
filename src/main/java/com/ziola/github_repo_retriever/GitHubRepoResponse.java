package com.ziola.github_repo_retriever;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
record GitHubRepoResponse(
        String name,
        boolean fork,
        Owner owner
) {
    record Owner(String login) {
    }
}
