package com.ziola.github_repo_retriever;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
record GitHubBranchResponse(
        String name,
        Commit commit
) {
    record Commit(String sha) {
    }
}
