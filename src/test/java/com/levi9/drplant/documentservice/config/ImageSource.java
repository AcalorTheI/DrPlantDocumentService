package com.levi9.drplant.documentservice.config;

import java.util.stream.Stream;

public class ImageSource {

    public static Stream<String> getImageAndMetadata() {
        String image = "/9j/4AAQSkZJRgABAQEAYABgAAD/4QLsRXhpZgAATU0AKgAAAAgABAE7AAIAAAALAAABSodpAAQAAAABAAABVpydAAEAAAAWAAACzuocAAcAAAEMAAAAPgAAAAAc6gAAAAEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAQWxla3NhbmRhcgAAAAWQAwACAAAAFAAAAqSQBAACAAAAFAAAAriSkQACAAAAAzc4AACSkgACAAAAAzc4AADqHAAHAAABDAAAAZgAAAAAHOoAAAABAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADIwMjQ6MDI6MjYgMTE6NDc6NDkAMjAyNDowMjoyNiAxMTo0Nzo0OQAAAEEAbABlAGsAcwBhAG4AZABhAHIAAAD/4QQdaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wLwA8P3hwYWNrZXQgYmVnaW49J++7vycgaWQ9J1c1TTBNcENlaGlIenJlU3pOVGN6a2M5ZCc/Pg0KPHg6eG1wbWV0YSB4bWxuczp4PSJhZG9iZTpuczptZXRhLyI+PHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj48cmRmOkRlc2NyaXB0aW9uIHJkZjphYm91dD0idXVpZDpmYWY1YmRkNS1iYTNkLTExZGEtYWQzMS1kMzNkNzUxODJmMWIiIHhtbG5zOmRjPSJodHRwOi8vcHVybC5vcmcvZGMvZWxlbWVudHMvMS4xLyIvPjxyZGY6RGVzY3JpcHRpb24gcmRmOmFib3V0PSJ1dWlkOmZhZjViZGQ1LWJhM2QtMTFkYS1hZDMxLWQzM2Q3NTE4MmYxYiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIj48eG1wOkNyZWF0ZURhdGU+MjAyNC0wMi0yNlQxMTo0Nzo0OS43NzY8L3htcDpDcmVhdGVEYXRlPjwvcmRmOkRlc2NyaXB0aW9uPjxyZGY6RGVzY3JpcHRpb24gcmRmOmFib3V0PSJ1dWlkOmZhZjViZGQ1LWJhM2QtMTFkYS1hZDMxLWQzM2Q3NTE4MmYxYiIgeG1sbnM6ZGM9Imh0dHA6Ly9wdXJsLm9yZy9kYy9lbGVtZW50cy8xLjEvIj48ZGM6Y3JlYXRvcj48cmRmOlNlcSB4bWxuczpyZGY9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkvMDIvMjItcmRmLXN5bnRheC1ucyMiPjxyZGY6bGk+QWxla3NhbmRhcjwvcmRmOmxpPjwvcmRmOlNlcT4NCgkJCTwvZGM6Y3JlYXRvcj48L3JkZjpEZXNjcmlwdGlvbj48L3JkZjpSREY+PC94OnhtcG1ldGE+DQogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg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fOjMbbh0BIPHvxUNXKqn+P43/wAwSt/Xp/kdLBcy2PiLS4RM0LLDFFOofGOc7W/McUzSnvU8a2P9sNMJ94VTcE5GchevbJrnaKl1L797hbSxMLac3gthE/2jfs8vHzbs4xj1zWn4iU3XjC9S0Hmu9wVXZzubODj15qj/AGrf/ajc/bJvtBTyzLvO7bjGM9enFRW13cWcpktZnhkKld6Ng4PUZrNO1gL/AIodJPFOoNGwYecQSOhI4P65rKoopDCiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooA1qKKKokKKKKACiiigCvP/rB9KiqWf8A1g+lRUhlj7L+7ZhNGSqByozkA49sd/Wq9Tb1W0KKfndst7AdP5/pUNABRRRQAVJD95/+ub/+gmo6kh+8/wD1zf8A9BNAFKiiikMKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKANaiiiqJCiiigAooooArz/wCsH0qKpZ/9YPpUVIYUVba1QWnm/P8AdBD5G0k/w49ev5VUoAKKKKACpIfvP/1zf/0E1HUkP3n/AOub/wDoJoApUVZsIba4uhHeTTRI3AMMIlYt2G0sv86n1vTodK1R7O3ujc+WBvYxhCrY5UgEjI6detLzGZ9FWLK2S7nMct3BaDbnzJ920+3yqTn8KLy2S1n8uK7gu1258yDdt+nzKDn8KAK9FaGi6WdXvzb+Y0YWNpDsj8xyFGcKuRuPtmpn0WE3N7Hb3butrbGcmS3MbZBA2MpPB56gkU7aXFcyaK37TwzHO8fnXxhR7WK4LCHdgvIEC43epzmhPDsSa/p1m9yZoLob3dU2kBWZXAHPdDg/SjlfULowKK1IIY9d1ZooVismdCLaGNPlZgPlQknqemTnJ+tV9UsF029Nr5wlljUedhcBH7pnPOOmfXNIZTooq5p2n/2j9pVZdksMDTIm3PmbeSOvHy5PfpQBTorUaGPRLy0NxHHeedbrLNBImAofkLnOc7cHPGM1DrVimm61d2kTFo4pCELddvbPvim1YRRooopDCiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKANaiiiqJCiiig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";
        String extension = ".jpg";
        String plant = "TULIP";

        return Stream.of(image + "," + extension + "," + plant);
    }
}
