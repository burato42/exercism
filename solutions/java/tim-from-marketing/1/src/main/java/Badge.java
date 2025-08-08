

class Badge {
    public String print(Integer id, String name, String department) {
        var idStr = id != null ? String.format("[%d] - ", id) : "";
        var dep = department != null ? String.format(" - %s", department.toUpperCase()) : " - OWNER";
        return idStr + name + dep;
    }
}
