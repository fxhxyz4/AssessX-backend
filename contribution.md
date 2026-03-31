# Contributing
 
## Git hooks (Lefthook)
 
This project uses [Lefthook](https://github.com/evilmartians/lefthook) to enforce branch naming conventions.
Every `git push` automatically validates that the branch name matches the required pattern.
 
### Allowed branch name formats
```
build/my-build
chore/my-chore
ci/ci-pipe
docs/docs-update
feat/my-feat
fix/my-fix
perf/my-perf
refactor/my-refactor
revert/my-revert
style/my-style
test/test-case
hotfix/some-update
release/new-release
update/new-update
```
 
---
 
### Installing Lefthook
 
#### Windows
```powershell
# via Scoop
scoop install lefthook
 
# or via Winget
winget install evilmartians.lefthook
```
 
#### macOS
```bash
# via Homebrew
brew install lefthook
```
 
#### Linux
```bash
# via Snap
sudo snap install lefthook --classic
 
# if the command is not found after snap install, add a symlink
sudo ln -s /snap/lefthook/current/lefthook /usr/local/bin/lefthook
 
# or download the binary directly
curl -L https://github.com/evilmartians/lefthook/releases/latest/download/lefthook_linux_amd64 \
  -o /usr/local/bin/lefthook
chmod +x /usr/local/bin/lefthook
```
 
---
 
### Setup
 
After installing, run this once in the project root:
```bash
lefthook install
```
 
This registers the hooks in `.git/hooks/`. From now on every `git push` will validate your branch name automatically.
 
### Verify installation
```bash
lefthook --version
```
 
---
 
### Bypassing the hook (use sparingly)
 
If you need to push without validation (e.g. directly to `main`):
```bash
git push origin main --no-verify
```

---

## Environment variables

The project uses a `.env` file for configuration. It is **not committed to the repository**.

Copy the example file and fill in your values:
```bash
cp .env.example .env
```

`.env.example` contains all required keys with empty values:
```env
DB_URL=
DB_PORT=
DB_NAME=
DB_USER=
DB_PASS=

GITHUB_CLIENT_ID=
GITHUB_CLIENT_SECRET=

JWT_SECRET=

PORT=8080
```

### Variable reference

| Variable | Description |
|---|---|
| `DB_URL` | PostgreSQL host |
| `DB_PORT` | PostgreSQL port |
| `DB_NAME` | Database name |
| `DB_USER` | PostgreSQL username |
| `DB_PASS` | PostgreSQL password |
| `GITHUB_CLIENT_ID` | GitHub OAuth App client ID |
| `GITHUB_CLIENT_SECRET` | GitHub OAuth App client secret |
| `JWT_SECRET` | Secret key for signing JWT tokens |
| `PORT` | Port the server listens on (default: 8080) |

> GitHub OAuth credentials can be obtained at https://github.com/settings/developers

> For `JWT_SECRET` use a long random string, e.g. generated with `openssl rand -base64 32`

---

## Running the project

### Prerequisites

Make sure you have the following installed:

- Java 21+
- Docker
- Docker Compose

---

### Docker Compose files

The project uses two Docker Compose files:

- `docker-compose.yml` — base configuration used in production (backend only, connects to external DB)
- `docker-compose.dev.yml` — local development override, automatically picked up by Docker Compose, adds a local PostgreSQL container and overrides DB connection to use it

---

### Local development

For local development, Docker Compose automatically merges `docker-compose.yml` and `docker-compose.dev.yml`. The local PostgreSQL container is started alongside the backend.
```bash
# 1. Build the JAR
cd AssessX-backend
./mvnw clean package -DskipTests
cd ..

# 2. Start backend + local PostgreSQL
docker compose up --build
```

The backend will be available at `http://localhost:8080`.

---

### Production (external DB)

For production, use only the base `docker-compose.yml` without the override:
```bash
docker compose -f docker-compose.yml up --build
```

Make sure all environment variables in `.env` point to your external database.

---

### Stopping services
```bash
docker compose down
```

To also remove the local database volume:
```bash
docker compose down -v
```
