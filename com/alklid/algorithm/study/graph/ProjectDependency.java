package alklid.algorithm.study.graph;

import java.util.HashMap;
import java.util.LinkedList;

// NodeGraphType 유사하게 정의
class Project {
    private String name;
    private LinkedList<Project> dependencies;
    private boolean marked;

    public Project(String name) {
        this.name = name;
        this.marked = false;
        this.dependencies = new LinkedList<>();
    }

    // 의존관계 프로젝트를 추가하는 함수
    public void addDependency(Project project) {
        if (!dependencies.contains(project)) {
            dependencies.add(project);
        }
    }

    // 의존관계 프로젝트를 반환하는 함수
    public LinkedList<Project> getDependencies() {
        return this.dependencies;
    }

    public String getName() {
        return this.name;
    }

    public boolean getMarked() {
        return this.marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }
}

// 프로젝트를 관리하는 Manager 클래스
class ProjectManager {
    // 프로젝트를 이름을 찾기 쉽게 HashMap 사용
    private HashMap<String, Project> projects;

    public ProjectManager(String[] names, String[][] dependencies) {
        buildProjects(names);
        addDependencies(dependencies);
    }

    // 이름으로 프로젝트를 만들어서 HashMap 에 저장
    public void buildProjects(String[] names) {
        projects = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            projects.put(names[i], new Project(names[i]));
        }
    }

    // 프로젝트 의존도를 설정하는 함수
    public void addDependencies(String[][] dependencies) {
        for (String[] dependency : dependencies) {
            Project before = findProject(dependency[0]);
            Project after = findProject(dependency[1]);

            // 뒤에 정의된 프로젝트의 디펜던시에 앞의 프로젝트를 설정
            after.addDependency(before);
        }
    }

    // 프로젝트의 진행순서를 확인하는 함수, 재귀를 시작시키는 함수
    private int index;
    public Project[] buildOrder() {
        initMarkingFlags();
        Project[] ordered = new Project[this.projects.size()];

        index = 0;
        for (Project project: this.projects.values()) {
            buildOrder(project, ordered);
        }

        return ordered;
    }

    // 프로젝트의 연관관계에 있는 프로젝트들 조회하면서 재귀호출
    public void buildOrder(Project project, Project[] ordered) {
        if (!project.getDependencies().isEmpty()) {
            for (Project p: project.getDependencies()) {
                buildOrder(p, ordered);
            }
        }

        // 모든 연관프로젝트 재귀를 다 돌았으면, 결과 배열방에 추가여부를 확인
        // 결과 배열방에 없으면 마킹하고 추가
        if (project.getMarked() == false) {
            project.setMarked(true);
            ordered[index] = project;
            index++;
        }
    }

    // 초기에 마킹을 모두 false 로 설정하는 함수
    private void initMarkingFlags() {
        for (Project project : this.projects.values()) {
            project.setMarked(false);
        }
    }

    // 이름으로 프로젝트를 찾는 함수
    public Project findProject(String name) {
        return this.projects.get(name);
    }
}

/**
 * 회사에 여러개의 프로젝트가 있는데 어떤 프로젝트들은 특정 프로젝트가 완료되어야만
 * 진행할 수 있는 프로젝트가 있다. 프로젝트의 목록과 각 프로젝트간 의존여부를
 * 넘겨주면 의존도에 입각한 프로젝트의 진행순서를 반환하는 함수를 구현하시오.
 *
 * projects : a, b, c, d, e, f, g
 * dependencies : (f, a), (f, b), (f, c), (b, a), (c, a), (a, e), (b, e), (d, g)
 *
 * LinkedList
 * |a| -> f -> b -> c
 * |b| -> f
 * |c| -> f
 * |d|
 * |e| -> a -> b
 * |f|
 * |g| -> d
 */
public class ProjectDependency {
    public static void main(String[] args) {
        String[] projects = {"a", "b", "c", "d", "e", "f", "g"};
        String[][] dependencies = {
            {"f", "a"},
            {"f", "b"},
            {"f", "c"},
            {"b", "a"},
            {"c", "a"},
            {"a", "e"},
            {"b", "e"},
            {"d", "g"}
        };

        ProjectManager pm = new ProjectManager(projects, dependencies);
        Project[] ps = pm.buildOrder();
        for (Project p : ps) {
            if (p != null) {
                System.out.print(p.getName() + " ");
            }
        }
    }
}
