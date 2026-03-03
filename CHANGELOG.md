# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [1.0.0] - 2026-03-03

### Added
- Initial release of Serralyse Backend API
- User registration and management system
- Skin analysis endpoint with personalized prescription generation
- DTO pattern implementation for clean API responses
- Global exception handling with custom exceptions
- PostgreSQL database integration with JPA/Hibernate
- Docker and Docker Compose support
- CI/CD pipeline with GitHub Actions
- Comprehensive API documentation
- Postman collection for API testing
- Health check endpoints (Spring Actuator)
- Data seeding for raw materials database

### Technical Implementation
- Spring Boot 4.0.1 framework
- Java 21 with modern language features
- RESTful API design following best practices
- Layered architecture (Controller → Service → Repository)
- Transaction management for data integrity
- Custom mappers for Entity-DTO conversion
- HikariCP connection pooling
- Environment-based configuration

### Documentation
- Comprehensive README with architecture diagrams
- Mermaid diagrams for system visualization
- Postman collection with example requests
- HTTP test file for API testing
- Contributing guidelines
- MIT License

### DevOps
- Dockerfile with multi-stage build
- Docker Compose for local development
- GitHub Actions CI/CD pipeline
- Health checks and monitoring endpoints

## [Unreleased]

### Planned Features
- Spring Security with JWT authentication
- Integration tests with TestContainers
- Redis caching layer
- Async processing capabilities
- WebSocket for real-time updates
- Flyway database migrations
- Enhanced prescription algorithms
- AWS S3 integration for image storage
- Email notification system

---

**Legend:**
- `Added` - New features
- `Changed` - Changes in existing functionality
- `Deprecated` - Soon-to-be removed features
- `Removed` - Removed features
- `Fixed` - Bug fixes
- `Security` - Security improvements
