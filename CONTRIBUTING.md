# Contributing to Serralyse

First off, thank you for considering contributing to Serralyse! 🎉

## Code of Conduct

This project and everyone participating in it is governed by our Code of Conduct. By participating, you are expected to uphold this code.

## How Can I Contribute?

### Reporting Bugs

Before creating bug reports, please check existing issues. When creating a bug report, include as many details as possible:

- **Use a clear and descriptive title**
- **Describe the exact steps to reproduce the problem**
- **Provide specific examples** (code snippets, API requests)
- **Describe the behavior you observed** and what you expected
- **Include screenshots** if applicable
- **Specify your environment** (OS, Java version, PostgreSQL version)

### Suggesting Enhancements

Enhancement suggestions are tracked as GitHub issues. When creating an enhancement suggestion:

- **Use a clear and descriptive title**
- **Provide a detailed description** of the suggested enhancement
- **Explain why this enhancement would be useful**
- **List some examples** of how it would be used

### Pull Requests

1. Fork the repo and create your branch from `main`
2. If you've added code, add tests
3. Ensure the test suite passes
4. Make sure your code follows the existing style
5. Write a clear commit message
6. Update documentation if needed

## Development Process

### Setup Development Environment

```bash
# Clone your fork
git clone https://github.com/your-username/serralyse-backend.git
cd serralyse-backend

# Create a branch
git checkout -b feature/my-new-feature

# Install dependencies
./mvnw clean install

# Run tests
./mvnw test
```

### Code Style

- Follow existing code style (Spring Boot conventions)
- Use Lombok annotations where appropriate
- Constructor injection preferred over field injection
- Keep methods focused and small
- Write meaningful variable and method names

### Commit Messages

- Use the present tense ("Add feature" not "Added feature")
- Use the imperative mood ("Move cursor to..." not "Moves cursor to...")
- Limit the first line to 72 characters
- Reference issues and pull requests after the first line

Example:
```
Add prescription validation logic

- Validate raw material stock levels
- Check user permissions
- Add integration tests

Closes #123
```

### Testing

- Write unit tests for new features
- Ensure integration tests pass
- Aim for >80% code coverage
- Test edge cases and error scenarios

```bash
# Run all tests
./mvnw test

# Run specific test
./mvnw test -Dtest=SkinAnalysisServiceTest
```

## Project Structure

```
src/main/java/com/serralyse/website/
├── config/          # Configuration classes
├── controller/      # REST endpoints
├── dto/            # Data Transfer Objects
├── entity/         # JPA entities
├── exception/      # Custom exceptions
├── mapper/         # Entity-DTO mappers
├── repository/     # Data access layer
└── service/        # Business logic
```

## Additional Notes

### Issue and Pull Request Labels

- `bug` - Something isn't working
- `enhancement` - New feature or request
- `documentation` - Documentation improvements
- `good first issue` - Good for newcomers
- `help wanted` - Extra attention needed

## Questions?

Feel free to open an issue with your question or reach out to the maintainers.

---

Thank you for contributing! 🚀
