import DashboardIcon from "@mui/icons-material/Dashboard";
import PeopleIcon from "@mui/icons-material/People";
import BusinessIcon from "@mui/icons-material/Business";
import AssignmentIcon from "@mui/icons-material/Assignment";

const menuConfig = {
  ADMIN: [
    {
      text: "Dashboard",
      icon: <DashboardIcon />,
      path: "/dashboard"
    },
    {
      text: "Empresas",
      icon: <BusinessIcon />,
      path: "/empresas"
    },
    {
      text: "Empleados",
      icon: <PeopleIcon />,
      path: "/empleados"
    },
    {
      text: "Operaciones",
      icon: <AssignmentIcon />,
      path: "/operaciones"
    }
  ],

  SUPERVISOR: [
    {
      text: "Dashboard",
      icon: <DashboardIcon />,
      path: "/dashboard"
    },
    {
      text: "Empleados",
      icon: <PeopleIcon />,
      path: "/empleados"
    },
    {
      text: "Operaciones",
      icon: <AssignmentIcon />,
      path: "/operaciones"
    }
  ],

  EMPLEADO: [
    {
      text: "Dashboard",
      icon: <DashboardIcon />,
      path: "/dashboard"
    },
    {
      text: "Mis tareas",
      icon: <AssignmentIcon />,
      path: "/tareas"
    }
  ]
};

export default menuConfig;