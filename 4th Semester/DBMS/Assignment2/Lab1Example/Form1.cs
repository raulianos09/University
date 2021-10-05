using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.SqlClient;
using System.Configuration;

namespace Lab1Example
{
    public partial class Form1 : Form
    {
        SqlConnection conn;
        SqlDataAdapter daParent, daChild;
        DataSet ds;
        SqlCommandBuilder cb;
        BindingSource bsParent, bsChild;

        private void btnSaveData_Click(object sender, EventArgs e)
        {
            daChild.Update(ds, "ChildTable");
        }

        private void btnRefresh_Click(object sender, EventArgs e)
        {
            ds.Clear();
            daParent.Fill(ds, "ParentTable");
            daChild.Fill(ds, "ChildTable");
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            string serverName = ConfigurationManager.AppSettings.Get("server");
            string databaseName = ConfigurationManager.AppSettings.Get("database"); ;
            conn = new SqlConnection("Server=" + serverName + ";Database=" + databaseName + ";Trusted_Connection=True");

            ds = new DataSet();
            
            string parentTable = ConfigurationManager.AppSettings.Get("parentTable");
            string childTable = ConfigurationManager.AppSettings.Get("childTable");
            
            daParent = new SqlDataAdapter("SELECT * FROM " + parentTable, conn);
            daChild = new SqlDataAdapter("SELECT * FROM " + childTable, conn);
            cb = new SqlCommandBuilder(daChild);
            daParent.Fill(ds, "ParentTable");
            daChild.Fill(ds, "ChildTable");

            string fk = ConfigurationManager.AppSettings.Get("fk");
            DataRelation dr = new DataRelation("FK_ParentTable_ChildTable",
                ds.Tables["ParentTable"].Columns[fk],
                ds.Tables["ChildTable"].Columns[fk]);
            ds.Relations.Add(dr);

            bsParent = new BindingSource();
            bsParent.DataSource = ds;
            bsParent.DataMember = "ParentTable";
            bsChild = new BindingSource();
            bsChild.DataSource = bsParent;
            bsChild.DataMember = "FK_ParentTable_ChildTable";

            dgvTrains.DataSource = bsParent;
            dgvTravelers.DataSource = bsChild;
        }

        public Form1()
        {
            InitializeComponent();
        }
    }
}
