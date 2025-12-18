package com.ziola.github_repo_retriever;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
class GitHubRepositoryService {
    private final GitHubApiClient githubClient;

    GitHubRepositoryService(GitHubApiClient githubClient) {
        this.githubClient = githubClient;
    }

    List<RepositoryDto> getUserRepositoriesWithBranches(String username) {
        return githubClient.getRepositories(username)
                .stream()
                .filter(repo -> !repo.fork())
                .map(repo -> {
                    List<BranchDto> branches = githubClient.getBranches(username, repo.name())
                            .stream()
                            .map(branch -> new BranchDto(branch.name(), branch.commit().sha()))
                            .toList();

                    return new RepositoryDto(repo.name(), repo.owner().login(), branches);
                })
                .toList();
    }
}
