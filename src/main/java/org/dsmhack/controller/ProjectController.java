package org.dsmhack.controller;

import org.dsmhack.model.Project;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
public class ProjectController {

    @GetMapping("/projects")
    public List<Project> getAllProjects() {
        Project fakeProject = createFakeProjectWith("project name");
        Project fakeProject1 = createFakeProjectWith("project name 2");
        return Arrays.asList(fakeProject, fakeProject1);
    }

    @GetMapping("/projects/{projectId}")
    public Project getProjectById(@PathVariable String projectId) {
        return createFakeProjectWith("project name and id: " + projectId);
    }

    private Project createFakeProjectWith(String project_name) {
        Project project = new Project();
        project.setProjId(new UUID(5l, 1l).toString());
        project.setName(project_name);
        project.setDescription("project description");
        project.setStartDate(Timestamp.valueOf("2012-01-01 00:00:00"));
        project.setEndDate(Timestamp.valueOf("2012-01-02 00:00:00"));
        return project;
    }
}