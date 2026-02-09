// @ts-check
// `@type` JSDoc annotations allow editor autocompletion and type checking
// (when paired with `@ts-check`).
// There are various equivalent ways to declare your Docusaurus config.
// See: https://docusaurus.io/docs/api/docusaurus-config

import {themes as prismThemes} from 'prism-react-renderer';

// This runs in Node.js - Don't use client-side code here (browser APIs, JSX...)

/** @type {import('@docusaurus/types').Config} */
const config = {
  title: 'Java Web Dev',
  tagline: 'Documentation for lab protection',
  favicon: 'img/favicon.ico',

  // Future flags, see https://docusaurus.io/docs/api/docusaurus-config#future
  future: {
    v4: true, // Improve compatibility with the upcoming Docusaurus v4
  },

  // Set the production url of your site here
  url: 'https://your-docusaurus-site.example.com',
  // Set the /<baseUrl>/ pathname under which your site is served
  // For GitHub pages deployment, it is often '/<projectName>/'
  baseUrl: '/',

  // GitHub pages deployment config.
  // If you aren't using GitHub pages, you don't need these.
  organizationName: 'Uladzislau Mikhayevich', // Usually your GitHub org/user name.
  projectName: 'Java Web Dev', // Usually your repo name.

  onBrokenLinks: 'throw',

  // Even if you don't use internationalization, you can use this field to set
  // useful metadata like html lang. For example, if your site is Chinese, you
  // may want to replace "en" with "zh-Hans".
  i18n: {
    defaultLocale: 'en',
    locales: ['en'],
  },

  presets: [
    [
      'classic',
      /** @type {import('@docusaurus/preset-classic').Options} */
      ({
        docs: {
          sidebarPath: './sidebars.js',
          // Please change this to your repo.
          // Remove this to remove the "edit this page" links.
          editUrl:
            'https://github.com/facebook/docusaurus/tree/main/packages/create-docusaurus/templates/shared/',
        },
        theme: {
          customCss: './src/css/custom.css',
        },
      }),
    ],
  ],

  themeConfig:
    /** @type {import('@docusaurus/preset-classic').ThemeConfig} */
    ({
      // Replace with your project's social card
      image: 'img/docusaurus-social-card.jpg',
      colorMode: {
        respectPrefersColorScheme: true,
      },
      navbar: {
        title: 'Java Web Dev',
        logo: {
          alt: 'My Site Logo',
          src: 'img/logo.svg',
        },
        items: [
          {
            type: 'docSidebar',
            sidebarId: 'lab1_1Sidebar',
            position: 'left',
            label: 'Lab 1.1',
          },
          {
            type: 'docSidebar',
            sidebarId: 'lab1_2Sidebar',
            position: 'left',
            label: 'Lab 1.2',
          },
          {
            type: 'docSidebar',
            sidebarId: 'lab2_1Sidebar',
            position: 'left',
            label: 'Lab 2.1',
          },
          {
            type: 'docSidebar',
            sidebarId: 'lab2_2Sidebar',
            position: 'left',
            label: 'Lab 2.2',
          },
          {
            type: 'docSidebar',
            sidebarId: 'lab3_1Sidebar',
            position: 'left',
            label: 'Lab 3.1',
          },
          {
            type: 'docSidebar',
            sidebarId: 'lab3_2Sidebar',
            position: 'left',
            label: 'Lab 3.2',
          },
          {
            type: 'docSidebar',
            sidebarId: 'lab4Sidebar',
            position: 'left',
            label: 'Lab 4',
          },
          {
            type: 'docSidebar',
            sidebarId: 'task1Sidebar',
            position: 'left',
            label: 'Task 1',
          },
          {
            type: 'docSidebar',
            sidebarId: 'task2Sidebar',
            position: 'left',
            label: 'Task 2',
          },
          {
            type: 'docSidebar',
            sidebarId: 'task3Sidebar',
            position: 'left',
            label: 'Task 3',
          },
          {
            type: 'docSidebar',
            sidebarId: 'task4Sidebar',
            position: 'left',
            label: 'Task 4',
          },
          {
            href: 'https://github.com/exxecute/SDC_5_Web_Dev_Java',
            label: 'GitHub',
            position: 'right',
          },
        ],
      },
      footer: {
        style: 'dark',
        links: [
        ],
        copyright: `Copyright © ${new Date().getFullYear()} My Project, Inc. Built with Docusaurus.`,
      },
      prism: {
        additionalLanguages: ['java'],
        theme: prismThemes.github,
        darkTheme: prismThemes.dracula,
      },
    }),
};

export default config;
