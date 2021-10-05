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
        DataSet ds;
        SqlDataAdapter daParent, daChild;
        SqlCommandBuilder cbParent;
        BindingSource bsParent, bsChild;

        private void btnSaveData_Click(object sender, EventArgs e)
        {
            daChild.Update(ds, "Traveler");
        }

        private void btnRefresh_Click(object sender, EventArgs e)
        {
            Form1_Load(sender, e);
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            string serverName = ConfigurationManager.AppSettings.Get("server");
            string databaseName = ConfigurationManager.AppSettings.Get("database");

            conn = new SqlConnection("Server=" + serverName + ";Database=" + databaseName + ";Trusted_Connection=True");

            ds = new DataSet();
            string parentTable = ConfigurationManager.AppSettings.Get("ParentTable");
            string childTable = ConfigurationManager.AppSettings.Get("ChildTable");
            
            daParent = new SqlDataAdapter("Select * FROM " + parentTable, conn);
            daChild = new SqlDataAdapter("Select * FROM " + childTable, conn);    
            cbParent = new SqlCommandBuilder(daChild);

            daParent.Fill(ds, "ParentTable");
            daChild.Fill(ds, "ChildTable");

            DataRelation dr = new DataRelation("FK_Travelers_Trains" , ds.Tables["Train"].Columns["trainId"], ds.Tables["Traveler"].Columns["travelsBy"]);

            ds.Relations.Add(dr);

            bsParent = new BindingSource();
            bsParent.DataSource = ds;
            bsParent.DataMember = "Train";

            dgvTrains.DataSource = bsParent;


            bsChild = new BindingSource();
            bsChild.DataSource = bsParent;
            bsChild.DataMember = "FK_Travelers_Trains";

            dgvTravelers.DataSource = bsChild;
        }

        public Form1()
        {
            InitializeComponent();
        }
    }
}
