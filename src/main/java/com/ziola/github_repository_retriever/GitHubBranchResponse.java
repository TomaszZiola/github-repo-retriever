package com.ziola.github_repository_retriever;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
record GitHubBranchResponse(
        String name,
        Commit commit
) {
    record Commit(String sha) {
    }
}
