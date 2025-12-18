package com.ziola.github_repo_retriever;

import java.util.List;

record RepositoryDto(
        String repositoryName,
        String ownerLogin,
        List<BranchDto> branches
) {
}