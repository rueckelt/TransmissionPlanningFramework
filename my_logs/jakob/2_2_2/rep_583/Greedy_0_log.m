
% 2016-10-14 11:50:36

% my_logs/jakob/2_2_2/rep_583/Greedy_0_log.m
scheduling_duration_us = 14308;

% schedule
schedule_f_t_n(:,:,1) = [0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 38, 0, 0, 0; 38, 0, 0, 0; 38, 0, 0, 0; 38, 0, 0, 0; 38, 0, 0, 0; 38, 0, 0, 0; 38, 0, 0, 0; 38, 0, 0, 0; 38, 0, 0, 0; 38, 0, 0, 0; 38, 0, 0, 0; 38, 0, 0, 0; 38, 0, 0, 0; 0, 0, 0, 58; 0, 0, 0, 58; 0, 0, 0, 58; 38, 0, 0, 0; 38, 0, 0, 0; 38, 0, 0, 0; 18, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0];
schedule_f_t_n(:,:,2) = [0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0];
schedule_f_t_n(:,:,3) = [0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 0, 0, 0, 7; 0, 0, 0, 7; 0, 0, 0, 7; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 0, 0, 7, 0; 0, 0, 7, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 4, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0];
schedule_f_t_n(:,:,4) = [0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 38, 0, 0, 0; 38, 0, 0, 0; 38, 0, 0, 0; 38, 0, 0, 0; 38, 0, 0, 0; 38, 0, 0, 0; 38, 0, 0, 0; 38, 0, 0, 0; 38, 0, 0, 0; 38, 0, 0, 0; 38, 0, 0, 0; 38, 0, 0, 0; 38, 0, 0, 0; 38, 0, 0, 0; 38, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0];

% cost function results
vioSt = [1596, 0, 980, 4788];
vioDl = [0, 0, 0, 7980];
vioNon = [0, 7040, 0, 123600];
vioTpMin = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 14, 52, 90, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
vioTp = [57, 0, 15300, 0];
vioLcy = [0, 0, 12800, 0];
vioJit = [0, 0, 450, 0];
cost_vio = 1679244;
cost_switches = 6000;
cost_ch = 523185;
costTotal = 2208429;

% Greedy_0
% 
% ############### Network 0 ##############
% cap	|[0]45	|45	|45	|45	|45	|45	|45	|45	|45	|45	|[10]45	|45	|45	|45	|45	|45	|45	|45	|45	|45	|[20]45	|45	|45	|45	|45	|45	|45	|45	|45	|45	|[30]45	|45	|45	|45	|45	|45	|45	|45	|45	|45	|[40]45	|45	|45	|45	|45	|45	|45	|45	|45	|45	|[50]45	|45	|45	|45	|45	|45	|45	|45	|45	|45	|[60]45	|45	|45	|45	|45	|45	|45	|45	|45	|45	|[70]45	|45	|45	|45	|45	|45	|45	|45	|45	|45	|[80]45	|45	|45	|45	|45	|45	|45	|45	|45	|45	|[90]45	|45	|45	|45	|45	|45	|45	|45	|45	|45	|
% F0	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|	|38	|38	|38	|38	|38	|[20]38	|38	|38	|38	|38	|38	|38	|38	|	|	|[30]	|38	|38	|38	|18	|	|	|	|	|	|[40]	|	|	|	|	|	|	|	|	|	|[50]	|	|	|	|	|	|	|	|	|	|[60]	|	|	|	|	|	|	|	|	|	|[70]	|	|	|	|	|	|	|	|	|	|[80]	|	|	|	|	|	|	|	|	|	|[90]	|	|	|	|	|	|	|	|	|	|
% F2	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|7	|7	|7	|7	|7	|7	|7	|[20]7	|7	|7	|7	|7	|7	|7	|7	|	|	|[30]	|7	|7	|7	|7	|7	|7	|7	|7	|7	|[40]7	|7	|7	|7	|7	|7	|7	|7	|7	|7	|[50]7	|7	|7	|7	|7	|7	|7	|7	|7	|7	|[60]7	|7	|7	|7	|	|	|7	|7	|7	|7	|[70]7	|7	|7	|7	|7	|7	|7	|7	|7	|7	|[80]7	|4	|	|	|	|	|	|	|	|	|[90]	|	|	|	|	|	|	|	|	|	|
% F3	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|	|	|	|	|	|[30]	|	|	|	|	|	|	|	|	|	|[40]	|	|	|	|38	|38	|38	|38	|38	|38	|[50]38	|38	|38	|38	|38	|38	|38	|38	|38	|	|[60]	|	|	|	|	|	|	|	|	|	|[70]	|	|	|	|	|	|	|	|	|	|[80]	|	|	|	|	|	|	|	|	|	|[90]	|	|	|	|	|	|	|	|	|	|
% ############### Network 1 ##############
% cap	|[0]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[10]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[20]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[30]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[40]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[50]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[60]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[70]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[80]0	|0	|0	|0	|0	|56	|56	|56	|0	|0	|[90]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|
% ############### Network 2 ##############
% cap	|[0]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[10]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[20]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[30]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[40]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[50]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[60]0	|0	|0	|0	|97	|97	|0	|0	|0	|0	|[70]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[80]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[90]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|
% F2	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|	|	|	|	|	|[30]	|	|	|	|	|	|	|	|	|	|[40]	|	|	|	|	|	|	|	|	|	|[50]	|	|	|	|	|	|	|	|	|	|[60]	|	|	|	|7	|7	|	|	|	|	|[70]	|	|	|	|	|	|	|	|	|	|[80]	|	|	|	|	|	|	|	|	|	|[90]	|	|	|	|	|	|	|	|	|	|
% ############### Network 3 ##############
% cap	|[0]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[10]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[20]0	|0	|0	|0	|0	|0	|0	|0	|65	|65	|[30]65	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[40]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[50]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[60]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[70]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[80]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[90]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|
% F0	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|	|	|	|58	|58	|[30]58	|	|	|	|	|	|	|	|	|	|[40]	|	|	|	|	|	|	|	|	|	|[50]	|	|	|	|	|	|	|	|	|	|[60]	|	|	|	|	|	|	|	|	|	|[70]	|	|	|	|	|	|	|	|	|	|[80]	|	|	|	|	|	|	|	|	|	|[90]	|	|	|	|	|	|	|	|	|	|
% F2	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|	|	|	|7	|7	|[30]7	|	|	|	|	|	|	|	|	|	|[40]	|	|	|	|	|	|	|	|	|	|[50]	|	|	|	|	|	|	|	|	|	|[60]	|	|	|	|	|	|	|	|	|	|[70]	|	|	|	|	|	|	|	|	|	|[80]	|	|	|	|	|	|	|	|	|	|[90]	|	|	|	|	|	|	|	|	|	|

