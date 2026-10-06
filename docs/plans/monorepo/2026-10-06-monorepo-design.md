# ITRV Multi-Module Repository Design

## Goal

Publish the current gateway, customer, and inventory services as independent Gradle modules in one repository.

## Layout

The repository root owns the Gradle wrapper, shared settings, README, and ignore rules. Each service keeps its own build file and source tree:

```text
itrv/
├── README.md
├── settings.gradle.kts
├── gradlew
├── gradlew.bat
├── gradle/wrapper/
├── gateway-service/
├── customer-service/
└── inventory-service/
```

`settings.gradle.kts` names the root project `itrv` and includes all three service directories as Gradle projects. Mixed Kotlin and Groovy module build scripts remain supported.

## Source Integration

Copy each service's committed build file and `src` tree. The gateway module includes its Spring Security configuration and Docker host routes. Exclude nested `.git`, `.gradle`, `build`, IDE metadata, module wrappers, and module settings files.

The original service repositories remain unchanged. The aggregate repository records a snapshot rather than preserving their separate commit histories.

## Publication

Initialize a new repository on branch `main`, create one commit named `first commit`, add `https://github.com/khamzatMurj/itrv.git` as `origin`, and push `main`. The target repository was verified empty before implementation.

## Acceptance Criteria

- Gradle lists `gateway-service`, `customer-service`, and `inventory-service` as projects.
- An aggregate assembly succeeds without running tests.
- The working tree is clean after the initial commit.
- GitHub `main` points to the local initial commit.

## Risks

- External dependency access can fail if the local corporate certificate configuration blocks registries or Maven repositories.
- Gateway upstream addresses use `host.docker.internal`, which is appropriate for the current Docker Desktop environment.

