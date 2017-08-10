import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/course-schedule/description/
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have 
 * to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it 
 * possible for you to finish all courses?
 * For example:
 * 2, [[1,0]]
 * There are a total of 2 courses to take. To take course 1 you should have 
 * finished course 0. So it is possible.
 * 2, [[1,0],[0,1]]
 * There are a total of 2 courses to take. To take course 1 you should have 
 * finished course 0, and to take course 0 you should also have finished 
 * course 1. So it is impossible.
 * Note:
 * The input prerequisites is a graph represented by a list of edges, not 
 * adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.

 * @author BigTiannn
 *
 */

public class CourseSchedule {
  // key idea is to detect if there's a cycle in a graph
  // bfs
  public boolean solution(int numCourses, int[][] prerequisites) {
    int[][] graph = new int[numCourses][numCourses];
    int[] inDegree = new int[numCourses];
    for (int i = 0; i < prerequisites.length; i ++) {
      int pre = prerequisites[i][1], curr = prerequisites[i][0];
      graph[pre][curr] = 1;
      inDegree[curr] ++;
    }
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i ++) {
      if (inDegree[i] == 0) queue.add(i);
    }
    while (!queue.isEmpty()) {
      int course = queue.poll();
      for (int i = 0; i < numCourses; i ++) {
        if (graph[course][i] == 1 && -- inDegree[i] == 0) {
          queue.add(i);
        }
      }
    }
    for (int i = 0; i < numCourses; i ++) {
      if (inDegree[i] != 0) return false;
    }
    return true;
  }
  
  // dfs
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    ArrayList[] graph = new ArrayList[numCourses];
    for (int i = 0; i < numCourses; i ++) {
        graph[i] = new ArrayList<Integer>();
    }
    for (int i = 0; i < prerequisites.length; i ++) {
      int pre = prerequisites[i][1], curr = prerequisites[i][0];
      graph[pre].add(curr);
    }
    boolean[] visited = new boolean[numCourses];
    for (int i = 0; i < numCourses; i ++) {
        if (!canFinishDfs(graph, visited, i))
            return false;
    }

    return true;
  }
  private boolean canFinishDfs(ArrayList[] graph, boolean[] visited, int course) {
    if (visited[course]) return false;
    visited[course] = true;
    for (int i = 0; i < graph[course].size(); i ++) {
        if (!canFinishDfs(graph, visited, (int)graph[course].get(i)))
          return false;
    }
    visited[course] = false;
    return true;
  }
  
  public boolean solution3(int numCourses, int[][] prerequisites) {
    for (int i = 0; i < prerequisites.length; i ++) {
      int[] p = new int[2];
      p[0] = prerequisites[i][0];
      p[1] = prerequisites[i][1];
      for (int j = 0; j < prerequisites.length; j ++){
        if (j == i) continue;
        if (prerequisites[j][0] == p[1]){
          p[1] = prerequisites[j][1];
          if (p[0] == p[1]) return false;
        }
      }
    }
    return true;
  }
  
    
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    CourseSchedule test = new CourseSchedule();
    int[][] a = {{1,0},{2,1},{3,2},{1,3}};
    System.out.println(test.solution(4, a));
  }

}
