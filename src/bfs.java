public class bfs {
    static Problem problem = new Problem(BusRoutes.home, false, 0);
    Node initialState = BusRoutes.home;
    Node nodeBeingChecked = new Node(BusRoutes.home.place);
}
