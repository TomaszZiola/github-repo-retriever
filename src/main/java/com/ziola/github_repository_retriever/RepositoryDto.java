package com.ziola.github_repository_retriever;

import java.util.List;

record RepositoryDto(
        String repositoryName,
        String ownerLogin,
        List<BranchDto> branches
) {
}